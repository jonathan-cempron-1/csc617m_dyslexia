grammar Dyslexia;

program :  code_block 
        ;

code_block : func_block*
             IntKeyword MainKeyword OP CP OB 
             ( var_dec
             | if_stmt
             | while_stmt
             | do_while_stmt
             | for_stmt
             | switch_stmt
             | func_call )*
             ReturnKeyword IntegerLiteral Terminator
             CB
           ;

literal_list : IntegerLiteral
             | StringLiteral
             | FloatLiteral
             // | CharacterLiteral 
             ;
const_dec : ConstantKeyword var_dec ;

expr : expr Exponent expr
     | Subtraction expr
     | Not expr
     | expr ( Multiplication | Division | Modulo ) expr
     | expr ( Addition | Subtraction ) expr
     | expr ( LessThanOrEqual | LessThan | GreaterThan | GreaterThanOrEqual ) expr
     | expr ( IsEqual | NotEqual ) expr
     | expr And expr
     | expr Or expr
     | atom
     ;

atom : OP expr CP
     | Identifier
     | BooleanLiteral
     | IntegerLiteral
     | FloatLiteral
     // | CharacterLiteral - causing error
     | StringLiteral
     | NullLiteral
     ;

var_assign : Identifier Assignment expr Terminator;

switch_expr : literal_list Identifier ;

func_assign : Identifier Assignment func_call Terminator ;

func_call : Identifier OP func_call_parameter CP Terminator ;

func_call_parameter : ( (Identifier | expr) ( Comma (Identifier | expr) )* )*;

func_dec : Identifier OP func_par CP ;

func_par : ( datatype? Identifier ( Comma datatype Identifier )* )* ;

func_block : ( datatype | VoidKeyword ) func_dec statement_block ;

output_call : OutputKeyword OP atom CP Terminator ;

input_call : Identifier Assignment InputKeyword OP datatype CP Terminator ;

array_dec1 : datatype Identifier AOBT expr ACBT Terminator ;

array_dec2 : datatype Identifier AOBT expr ACBT Assignment OB ( expr ( Comma expr)*)+ CB Terminator ;

return_stmt : ReturnKeyword expr Terminator ;

switch_stmt : SwitchKeyword OP expr CP OB ( CaseKeyword switch_expr Colon statement_block break_stmt )+ CB ;

break_stmt : BreakKeyword Terminator ;

if_stmt : IfKeyword OP condition_block CP statement_block ( ElseIfKeyword OP condition_block CP statement_block )* ( ElseKeyword statement_block )? ;

while_stmt : WhileKeyword OP condition_block CP statement_block;

do_while_stmt : DoKeyword statement_block WhileKeyword OP condition_block CP Terminator;

for_stmt : ForKeyword OP var_dec condition_block Terminator statement CP statement_block;

var_dec_additional : ( Comma var_dec_single )* ;
var_dec_single : Identifier Assignment expr ;
var_dec : datatype  var_dec_single var_dec_additional Terminator ;
            
datatype : IntKeyword
         | FloatKeyword
         | StringKeyword
         | CharacterKeyword
         ;

statement : var_dec 
          | const_dec
          | array_dec1
          | array_dec2
          | var_assign
          | if_stmt
          | while_stmt
          | do_while_stmt
          | for_stmt
          | switch_stmt
          | break_stmt
          | return_stmt
          | func_dec
          | func_call
          | func_assign
          | array_dec1
          | array_dec2
          | output_call
          | input_call
          ;

statements : statement* ;

condition_block : expr*;

statement_block : ( OB statements CB ) | statement ;

// LITERAL
IntegerLiteral	:	'-'?DIGIT+ ; // missing negative
fragment DIGIT : [0-9];
FloatLiteral	:	[-]?[0-9]*'.'?[0-9] + ([eE][-+]?[0-9]+)? ;
// CharacterLiteral	:	[A-Za-z0-9\\n]  ;
//StringLiteral	:	'"' [A-Za-z0-9] '"' ; // fix spaces are not detected
StringLiteral   :   '"' SCharSequence? '"'; // spaces are detected within quotation marks
// For Strings
fragment
SCharSequence
    :   SChar+
    ;
fragment
SChar
    :   ~["\\\r\n]
    |   EscapeSequence
    |   '\\\n'   // Added line
    |   '\\\r\n' // Added line
;
fragment
EscapeSequence
    :   SimpleEscapeSequence
    ;

fragment
SimpleEscapeSequence
    :   '\\' ['"?abfnrtv\\]
    ;

// For strings
NullLiteral	:	'llun' ;
BooleanLiteral  :       'eurt' | 'eslaf' ;

//KEYWORDS
IntKeyword	:	'tni' ;
FloatKeyword	:	'taolf' ;
StringKeyword	:	'gnirts' ;
CharacterKeyword	:	'rahc' ;
IfKeyword	:	'fi' ;
ElseKeyword	:	'esle' ;
ElseIfKeyword	:	'esle fi' ;
WhileKeyword	:	'elihw' ;
ForKeyword	:	'rof' ;
DoKeyword	:	'od' ;
SwitchKeyword	:	'hctiws' ;
CaseKeyword	:	'esac' ;
BreakKeyword	:	'kaerb' ;
ReturnKeyword	:	'nruter' ;
MainKeyword     :       'niam';
VoidKeyword	:	'diov' ;
ConstantKeyword	:	'tsnoc' ;
InputKeyword	:	'tupni' ;
OutputKeyword	:	'tuptuo' ;

// SEPARATORS
AOBT	:	'[' ;
ACBT	:	']' ;
OB	:	'{' ;
CB	:	'}' ;
Comma	:	',' ;
OP	:	'(' ;
CP	:	')' ;
Colon	:	':' ;

// OPERATORS
Addition : '+' ;
Subtraction : '-' ;
Multiplication : '*' ;
Division : '/' ;
Modulo	: '%' ;
Exponent : '^' ;
LessThan : '<' ;
GreaterThan : '>' ;
LessThanOrEqual : '<=' ;
GreaterThanOrEqual : '>=' ;
IsEqual : '==' ;
NotEqual : '!=' ;
And : '&&' ;
Not : '!' ;
Or : '||' ;
Ampersand : '&' ;
Assignment : '=' ;

// Identifiers
Identifier	:	[A-Za-z][A-Za-z]* ;

// Comment
Comment	:	'/*' .*? '*/' -> skip; // fixed
Terminator :	';' ;

// SPACES
WhiteSpace : ' '+ -> skip;
TabSpace : '\t'+ -> skip;
NextLineSpace : '\n'+ -> skip;
Windows : '\r'+ -> skip;