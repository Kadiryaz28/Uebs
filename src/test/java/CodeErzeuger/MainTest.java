package CodeErzeuger;

import StackInterpreter.Interpreter;
import junitparams.JUnitParamsRunner;
import org.junit.runner.RunWith;
import junitparams.Parameters;
import org.junit.Test;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.stringtemplate.v4.ST;


import java.io.*;
import static StackInterpreter.Interpreter.load;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;
@RunWith(JUnitParamsRunner.class)
public class MainTest {
    @Test
    @Parameters({"for"
                ,"forTwice"
                ,"funcCall"
                ,"ifElse"
                ,"ifgt"
                ,"iflt"
                ,"ifTrueFalse"
                ,"neq"
                ,"not"
                ,"printf"
                ,"uebungA"
                ,"uebungB"
                ,"uebungC"
                ,"uebungD"
                ,"uminus"
                ,"while"})
    public void testMain(String functionName) throws Exception {
        File file = new File(String.format("src/main/resources/ClobalProgs/%s.clobal", functionName));
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            System.out.print(stringBuilder);
        }
        assertTrue(check(file));

    }
    public boolean check(File f) throws Exception {
        ClobalLexer lexer = new ClobalLexer(new ANTLRFileStream(f.getAbsolutePath()));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ClobalParser parser = new ClobalParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.file();
        ParseTreeWalker walker = new ParseTreeWalker();
        Listener Listener = new Listener();
        walker.walk(Listener, tree);
        Listener.stack.forEach(st -> System.out.println(st.render()));
        String string = Listener.stack.stream().map(ST::render).collect(Collectors.joining("\n"));

        InputStream inputStream = new ByteArrayInputStream(string.getBytes());
        Interpreter interpreter = new Interpreter();
        load(interpreter, inputStream);
        interpreter.exec();
        interpreter.coredump();
        return true;
    }
}