package CodeErzeuger;

import StackInterpreter.Interpreter;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.stringtemplate.v4.ST;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.stream.Collectors;

import static StackInterpreter.Interpreter.load;

public class Main {
    //Teste in der Main for.clobal
    public static void main(String[] args) throws Exception {
        //Wandle Input in Tokens
        ClobalLexer lexer = new ClobalLexer(new ANTLRInputStream("""
                int n;
                int i;
                int main() {
                n = 1;
                for (i=0; i<3; i=i+1) {
                n=2*n;
                }
                n = 1;
                printf(n)
                ;return 0;
                }"""));
        // Speichere Tokenstream
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //Zerlegung und Umwandlung einer Eingabe für Weiterverarbeitung in geeigneterem Format
        ClobalParser parser = new ClobalParser(tokens);
        parser.setBuildParseTree(true);
        // Tree in Form von Text
        ParseTree tree = parser.file();
        // Ausgabe Tree in Form von Text
        System.out.println(tree.toStringTree(parser));
        //Walker führt Listener exitCall() aus, unabhängig davon wo er Funktionsaufrufe findet
        ParseTreeWalker walker = new ParseTreeWalker();
        Listener Listener = new Listener();
        // Mit Parse-Tree und Listener, erzeugt Walker Output
        walker.walk(Listener, tree);
        // Ausgabe der Variablen
        Listener.stack.forEach(st -> System.out.println(st.render()));
        //Erzeuge Stack und lese Bytes vom String Zeile für Zeile
        String string = Listener.stack.stream().map(ST::render).collect(Collectors.joining("\n"));
        InputStream inputStream = new ByteArrayInputStream(string.getBytes());
        //Erzeuge (Interpreter)Object, lade und assemble Bytecode-Programm und führe ihn aus
        //Lade/Gebe aus, Data Memory/ Code Memory
        Interpreter interpreter = new Interpreter();
        load(interpreter, inputStream);
        interpreter.exec();
        interpreter.coredump();
    }
}
