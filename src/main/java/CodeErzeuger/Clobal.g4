grammar Clobal;

@header {
}

file:  include* (functionDecl | varDecl)+ ;

include: '#include' ('<stdio.h>'| '<stdbool.h>');

functionDecl
    :   type ID '(' ')' block
    ;

stat:   block
    |   ifStat
    |   forStat
    |   whileStat
    |   returnStat ';'
    |   assignStat  ';'
    |   printStat  ';'
    |   expr ';'
    ;

block:  '{' stat* '}' ;

assignStat:  ID '=' expr ;

ifStat: 'if' '(' bexpr ')' stat ('else' stat)? ;

forStat: 'for' '(' assignStat ';' bexpr ';' assignStat ')' stat ;

whileStat: 'while' '(' bexpr ')' stat ;

returnStat: 'return' expr ;

printStat: 'printf' '(' FORMAT ',' expr ')';

varDecl:   type ID ';' ;

type:   'float' | 'int'  ;

expr:   '+' expr                        #ADD
    |   '-' expr                        #SUB
    |   '!' expr                        #NOT
    |   expr ('*') expr                 #MUL
    |   expr ('/') expr                 #DIV
    |   expr op=('+'|'-') expr          #ADDSUB
    |   expr op=('=='|'!='|'<'|'>') expr#COMPARISION
    |   ID                              #IDEXPR
    |   INT                             #INTEXPR
    |   '(' expr ')'                    #BRACKS
    |   ID '(' ')'                      #IDBRACKS
    ;

bexpr:   '!' bexpr
    |   expr op=('=='|'!='|'<'|'>') expr
    |   'true'
    |   'false'
    |   '(' bexpr ')'
    ;

INT: [0-9]+;
ID: [a-z] [a-zA-Z0-9]*;
WS: [ \r\t\n]+ -> skip ;
