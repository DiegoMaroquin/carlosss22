package leerarchivo;
import static leerarchivo.Tokens.*;
%%
%class Lexer
%type Tokens
%line
%column
L=[a-zA-Z_]
CA="\""[^*]~"\"" + "\""
D=[0-9]
ESPACIO=[ \t\r\n]
%{
    public String lexeme;
   InformacionAnalisis c=new InformacionAnalisis();
%}
%%

{ESPACIO} {/*Ignore*/}
"//".* {/*Ignore*/}
<YYINITIAL> "+" {c.linea=yyline; lexeme=yytext(); return MAS; }
<YYINITIAL> "==" {c.linea=yyline; lexeme=yytext(); return IGUAL; }
<YYINITIAL> "!=" {c.linea=yyline; lexeme=yytext(); return DISTINTO; }
<YYINITIAL> "-" {c.linea=yyline; lexeme=yytext(); return MENOS; }
<YYINITIAL> "||" {c.linea=yyline; lexeme=yytext(); return OR; }
<YYINITIAL> "&&" {c.linea=yyline; lexeme=yytext(); return AND; }
<YYINITIAL> "(" {c.linea=yyline; lexeme=yytext(); return  DELIMITADOR; }
<YYINITIAL> ")" {c.linea=yyline; lexeme=yytext(); return  DELIMITADOR; }
<YYINITIAL> "{" {c.linea=yyline; lexeme=yytext(); return  DELIMITADOR; }
<YYINITIAL> "}" {c.linea=yyline; lexeme=yytext(); return  DELIMITADOR; }
<YYINITIAL> "=" {c.linea=yyline; lexeme=yytext(); return ASIGNACION; }
<YYINITIAL> "/" {c.linea=yyline; lexeme=yytext(); return ENTRE; }
<YYINITIAL> "%" {c.linea=yyline; lexeme=yytext(); return MODULO; }
<YYINITIAL> "<" {c.linea=yyline; lexeme=yytext(); return MENOR; }
<YYINITIAL> ">" {c.linea=yyline; lexeme=yytext(); return MAYOR; }
<YYINITIAL> ";" {c.linea=yyline; lexeme=yytext(); return PUNTO_Y_COMA; }
<YYINITIAL> "*" {c.linea=yyline; lexeme=yytext(); return POR; }
<YYINITIAL> "main" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "if" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "while" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "else" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "putw" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "int" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "else" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "break" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "puts" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "char" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "String" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "boolean" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "float" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "abstract" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "case" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "catch" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "class" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "continue" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "default" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "do" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "double" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "enum" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "extends" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "for" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "implements" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "long" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "new" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "package" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "private" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "abstract" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "public" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "static" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "switch" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "synchronized" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "this" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "try" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "true" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "false" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "null" {c.linea=yyline; lexeme=yytext(); return RESERVADA; }
<YYINITIAL> "var" {c.linea=yyline; lexeme=yytext(); return IDENTIFICADORES; }
<YYINITIAL> "goto" {c.linea=yyline; lexeme=yytext(); return IDENTIFICADORES; }
<YYINITIAL> "const" {c.linea=yyline; lexeme=yytext(); return IDENTIFICADORES; }
<YYINITIAL> {D}+ {c.linea=yyline; lexeme=yytext(); return NUMERO; }
<YYINITIAL> {L} ({L}|{D})* {c.linea=yyline; lexeme=yytext(); return ID; }
<YYINITIAL> {CA}+ {c.linea=yyline; lexeme=yytext(); return CADENA; }
. {c.linea=yyline; lexeme=yytext(); return ERROR; }



