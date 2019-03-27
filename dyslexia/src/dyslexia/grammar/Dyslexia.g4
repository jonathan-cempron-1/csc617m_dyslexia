/*
 * [The "BSD license"]
 *  Copyright (c) 2014 Terence Parr
 *  Copyright (c) 2014 Sam Harwell
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. The name of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *  IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 *  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 *  THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * A Java 8 grammar for ANTLR 4 derived from the Java Language Specification
 * chapter 19.
 *
 * NOTE: This grammar results in a generated parser that is much slower
 *       than the Java 7 grammar in the grammars-v4/java directory. This
 *     one is, however, extremely close to the spec.
 *
 * You can test with
 *
 *  $ antlr4 Java8.g4
 *  $ javac *.java
 *  $ grun Java8 compilationUnit *.java
 *
 * Or,
~/antlr/code/grammars-v4/java8 $ java Test .
/Users/parrt/antlr/code/grammars-v4/java8/./Java8BaseListener.java
/Users/parrt/antlr/code/grammars-v4/java8/./Java8Lexer.java
/Users/parrt/antlr/code/grammars-v4/java8/./Java8Listener.java
/Users/parrt/antlr/code/grammars-v4/java8/./Java8Parser.java
/Users/parrt/antlr/code/grammars-v4/java8/./Test.java
Total lexer+parser time 30844ms.
 */
grammar Dyslexia;

/*
 * Productions from §3 (Lexical Structure)
 */

literal
	:	IntegerLiteral              # IntegerLiteral
	|	FloatingPointLiteral        # FloatingPointLiteral
	|	BooleanLiteral              # BooleanLiteral
	|	CharacterLiteral            # CharacterLiteral
	|	StringLiteral               # StringLiteral
	|	NullLiteral                 # NullLiteral
	;

/*
 * Productions from §4 (Types, Values, and Variables)
 */

primitiveType
	:	annotation* numericType
	|	annotation* 'naeloob'
	;

numericType
	:	integralType        # numericType_integralType
	|	floatingPointType   # numericType_floatingPointType
	;

integralType
	:	'etyb'
	|	'trohs'
	|	'tni'
	|	'gnol'
	|	'rahc'
	;

floatingPointType
	:	'taolf'
	|	'elbuod'
	;

referenceType
	:	classOrInterfaceType
	|	typeVariable
	|	arrayType
	;

classOrInterfaceType
	:	(	classType_lfno_classOrInterfaceType
		|	interfaceType_lfno_classOrInterfaceType
		)
		(	classType_lf_classOrInterfaceType
		|	interfaceType_lf_classOrInterfaceType
		)*
	;

classType
	:	annotation* Identifier typeArguments?
	|	classOrInterfaceType '.' annotation* Identifier typeArguments?
	;

classType_lf_classOrInterfaceType
	:	'.' annotation* Identifier typeArguments?
	;

classType_lfno_classOrInterfaceType
	:	annotation* Identifier typeArguments?
	;

interfaceType
	:	classType
	;

interfaceType_lf_classOrInterfaceType
	:	classType_lf_classOrInterfaceType
	;

interfaceType_lfno_classOrInterfaceType
	:	classType_lfno_classOrInterfaceType
	;

typeVariable
	:	annotation* Identifier
	;

arrayType
	:	primitiveType dims
	|	classOrInterfaceType dims
	|	typeVariable dims
	;

dims
	:	annotation* '[' ']' (annotation* '[' ']')*
	;

typeParameter
	:	typeParameterModifier* Identifier typeBound?
	;

typeParameterModifier
	:	annotation
	;

typeBound
	:	'sdnetxe' typeVariable
	|	'sdnetxe' classOrInterfaceType additionalBound*
	;

additionalBound
	:	'&' interfaceType
	;

typeArguments
	:	'<' typeArgumentList '>'
	;

typeArgumentList
	:	typeArgument (',' typeArgument)*
	;

typeArgument
	:	referenceType
	|	wildcard
	;

wildcard
	:	annotation* '?' wildcardBounds?
	;

wildcardBounds
	:	'sdnetxe' referenceType
	|	'repus' referenceType
	;

/*
 * Productions from §6 (Names)
 */

packageName
	:	Identifier
	|	packageName '.' Identifier
	;

typeName
	:	Identifier
	|	packageOrTypeName '.' Identifier
	;

packageOrTypeName
	:	Identifier
	|	packageOrTypeName '.' Identifier
	;

expressionName
	:	Identifier                      # expressionName_Identifier
	|	ambiguousName '.' Identifier    # expressionName_ambiguousName
	;

methodName
	:	Identifier
	;

ambiguousName
	:	Identifier
	|	ambiguousName '.' Identifier
	;

/*
 * Productions from §7 (Packages)
 */

compilationUnit
	:	packageDeclaration? importDeclaration* typeDeclaration* EOF
	;

packageDeclaration
	:	packageModifier* 'egakcap' packageName ';'
	;

packageModifier
	:	annotation
	;

importDeclaration
	:	singleTypeImportDeclaration
	|	typeImportOnDemandDeclaration
	|	singleStaticImportDeclaration
	|	staticImportOnDemandDeclaration
	;

singleTypeImportDeclaration
	:	'tropmi' typeName ';'
	;

typeImportOnDemandDeclaration
	:	'tropmi' packageOrTypeName '.' '*' ';'
	;

singleStaticImportDeclaration
	:	'tropmi' 'citats' typeName '.' Identifier ';'
	;

staticImportOnDemandDeclaration
	:	'tropmi' 'citats' typeName '.' '*' ';'
	;

typeDeclaration
	:	classDeclaration
	|	interfaceDeclaration
	|	';'
	;

/*
 * Productions from §8 (Classes)
 */

classDeclaration
	:	normalClassDeclaration
	|	enumDeclaration
	;

normalClassDeclaration
	:	classModifier* 'ssalc' Identifier typeParameters? superclass? superinterfaces? classBody
	;

classModifier
	:	annotation
	|	'cilbup'
	|	'detcetorp'
	|	'etavirp'
	|	'tcartsba'
	|	'citats'
	|	'lanif'
	|	'pftcirts'
	;

typeParameters
	:	'<' typeParameterList '>'
	;

typeParameterList
	:	typeParameter (',' typeParameter)*
	;

superclass
	:	'sdnetxe' classType
	;

superinterfaces
	:	'stnemelpmi' interfaceTypeList
	;

interfaceTypeList
	:	interfaceType (',' interfaceType)*
	;

classBody
	:	'{' classBodyDeclaration* '}'
	;

classBodyDeclaration
	:	classMemberDeclaration
	|	instanceInitializer
	|	staticInitializer
	|	constructorDeclaration
	;

classMemberDeclaration
	:	fieldDeclaration        # classMemberDeclaration_fieldDeclaration
	|	methodDeclaration       # classMemberDeclaration_methodDeclaration
	|	classDeclaration        # classMemberDeclaration_classDeclaration 
	|	interfaceDeclaration    # classMemberDeclaration_interfaceDeclaration
	|	';'                     # classMemberDeclaration_semicolon
	;

fieldDeclaration
	:	fieldModifier* unannType variableDeclaratorList ';'
	;

fieldModifier
	:	annotation
	|	'cilbup'
	|	'detcetorp'
	|	'etavirp'
	|	'citats'
	|	'lanif'
	|	'tneisnart'
	|	'elitalov'
	;

variableDeclaratorList
	:	variableDeclarator (',' variableDeclarator)*
	;

variableDeclarator
	:	variableDeclaratorId ('=' variableInitializer)?
	;

variableDeclaratorId
	:	Identifier dims?
	;

variableInitializer
	:	expression          # variableInitializer_expression
	|	arrayInitializer    # variableInitializer_arrayInitializer
	;

unannType
	:	unannPrimitiveType  # unannType_unannPrimitiveType
	|	unannReferenceType  # unannType_unannReferenceType
	;

unannPrimitiveType
	:	numericType # unannPrimitiveType_numericType
	|	'naeloob'   # unannPrimitiveType_boolean
	;

unannReferenceType
	:	unannClassOrInterfaceType   # unannReferenceType_ClassOrInterfaceType
	|	unannTypeVariable           # unannReferenceType_TypeVariable
	|	unannArrayType              # unannReferenceType_ArrayType
	;

unannClassOrInterfaceType
	:	(	unannClassType_lfno_unannClassOrInterfaceType
		|	unannInterfaceType_lfno_unannClassOrInterfaceType
		)
		(	unannClassType_lf_unannClassOrInterfaceType
		|	unannInterfaceType_lf_unannClassOrInterfaceType
		)*
	;

unannClassType
	:	Identifier typeArguments?
	|	unannClassOrInterfaceType '.' annotation* Identifier typeArguments?
	;

unannClassType_lf_unannClassOrInterfaceType
	:	'.' annotation* Identifier typeArguments?
	;

unannClassType_lfno_unannClassOrInterfaceType
	:	Identifier typeArguments?
	;

unannInterfaceType
	:	unannClassType
	;

unannInterfaceType_lf_unannClassOrInterfaceType
	:	unannClassType_lf_unannClassOrInterfaceType
	;

unannInterfaceType_lfno_unannClassOrInterfaceType
	:	unannClassType_lfno_unannClassOrInterfaceType
	;

unannTypeVariable
	:	Identifier
	;

unannArrayType
	:	unannPrimitiveType dims
	|	unannClassOrInterfaceType dims
	|	unannTypeVariable dims
	;

methodDeclaration
	:	methodModifier* methodHeader methodBody
	;

methodModifier
	:	annotation
	|	'cilbup'
	|	'detcetorp'
	|	'etavirp'
	|	'tcartsba'
	|	'citats'
	|	'lanif'
	|	'dezinorhcnys'
	|	'evitan'
	|	'pftcirts'
	;

methodHeader
	:	result methodDeclarator throws_?
	|	typeParameters annotation* result methodDeclarator throws_?
	;

result
	:	unannType   # result_unannType
	|	'diov'      # result_void
	;

methodDeclarator
	:	Identifier '(' formalParameterList? ')' dims?
	;

formalParameterList
	:	receiverParameter                           # formalParameterList_receiverParameter
	|	formalParameters ',' lastFormalParameter    # formalParameterList_formalParameters
	|	lastFormalParameter                         # formalParameterList_lastFormalParameter
	;

formalParameters
	:	formalParameter (',' formalParameter)*
	|	receiverParameter (',' formalParameter)*
	;

formalParameter
	:	variableModifier* unannType variableDeclaratorId
	;

variableModifier
	:	annotation  # variableModifier_annotation
	|	'lanif'     # variableModifier_final
	;

lastFormalParameter
	:	variableModifier* unannType annotation* '...' variableDeclaratorId
	|	formalParameter
	;

receiverParameter
	:	annotation* unannType (Identifier '.')? 'siht'
	;

throws_
	:	'sworht' exceptionTypeList
	;

exceptionTypeList
	:	exceptionType (',' exceptionType)*
	;

exceptionType
	:	classType
	|	typeVariable
	;

methodBody
	:	block
	|	';'
	;

instanceInitializer
	:	block
	;

staticInitializer
	:	'citats' block
	;

constructorDeclaration
	:	constructorModifier* constructorDeclarator throws_? constructorBody
	;

constructorModifier
	:	annotation
	|	'cilbup'
	|	'detcetorp'
	|	'etavirp'
	;

constructorDeclarator
	:	typeParameters? simpleTypeName '(' formalParameterList? ')'
	;

simpleTypeName
	:	Identifier
	;

constructorBody
	:	'{' explicitConstructorInvocation? blockStatements? '}'
	;

explicitConstructorInvocation
	:	typeArguments? 'siht' '(' argumentList? ')' ';'
	|	typeArguments? 'repus' '(' argumentList? ')' ';'
	|	expressionName '.' typeArguments? 'repus' '(' argumentList? ')' ';'
	|	primary '.' typeArguments? 'repus' '(' argumentList? ')' ';'
	;

enumDeclaration
	:	classModifier* 'mune' Identifier superinterfaces? enumBody
	;

enumBody
	:	'{' enumConstantList? ','? enumBodyDeclarations? '}'
	;

enumConstantList
	:	enumConstant (',' enumConstant)*
	;

enumConstant
	:	enumConstantModifier* Identifier ('(' argumentList? ')')? classBody?
	;

enumConstantModifier
	:	annotation
	;

enumBodyDeclarations
	:	';' classBodyDeclaration*
	;

/*
 * Productions from §9 (Interfaces)
 */

interfaceDeclaration
	:	normalInterfaceDeclaration
	|	annotationTypeDeclaration
	;

normalInterfaceDeclaration
	:	interfaceModifier* 'ecafretni' Identifier typeParameters? extendsInterfaces? interfaceBody
	;

interfaceModifier
	:	annotation
	|	'cilbup'
	|	'detcetorp'
	|	'etavirp'
	|	'tcartsba'
	|	'citats'
	|	'pftcirts'
	;

extendsInterfaces
	:	'sdnetxe' interfaceTypeList
	;

interfaceBody
	:	'{' interfaceMemberDeclaration* '}'
	;

interfaceMemberDeclaration
	:	constantDeclaration
	|	interfaceMethodDeclaration
	|	classDeclaration
	|	interfaceDeclaration
	|	';'
	;

constantDeclaration
	:	constantModifier* unannType variableDeclaratorList ';'
	;

constantModifier
	:	annotation
	|	'cilbup'
	|	'citats'
	|	'lanif'
	;

interfaceMethodDeclaration
	:	interfaceMethodModifier* methodHeader methodBody
	;

interfaceMethodModifier
	:	annotation
	|	'cilbup'
	|	'tcartsba'
	|	'tluafed'
	|	'citats'
	|	'pftcirts'
	;

annotationTypeDeclaration
	:	interfaceModifier* '@' 'ecafretni' Identifier annotationTypeBody
	;

annotationTypeBody
	:	'{' annotationTypeMemberDeclaration* '}'
	;

annotationTypeMemberDeclaration
	:	annotationTypeElementDeclaration
	|	constantDeclaration
	|	classDeclaration
	|	interfaceDeclaration
	|	';'
	;

annotationTypeElementDeclaration
	:	annotationTypeElementModifier* unannType Identifier '(' ')' dims? defaultValue? ';'
	;

annotationTypeElementModifier
	:	annotation
	|	'cilbup'
	|	'tcartsba'
	;

defaultValue
	:	'tluafed' elementValue
	;

annotation
	:	normalAnnotation
	|	markerAnnotation
	|	singleElementAnnotation
	;

normalAnnotation
	:	'@' typeName '(' elementValuePairList? ')'
	;

elementValuePairList
	:	elementValuePair (',' elementValuePair)*
	;

elementValuePair
	:	Identifier '=' elementValue
	;

elementValue
	:	conditionalExpression
	|	elementValueArrayInitializer
	|	annotation
	;

elementValueArrayInitializer
	:	'{' elementValueList? ','? '}'
	;

elementValueList
	:	elementValue (',' elementValue)*
	;

markerAnnotation
	:	'@' typeName
	;

singleElementAnnotation
	:	'@' typeName '(' elementValue ')'
	;

/*
 * Productions from §10 (Arrays)
 */

arrayInitializer
	:	'{' variableInitializerList? ','? '}'
	;

variableInitializerList
	:	variableInitializer (',' variableInitializer)*
	;

/*
 * Productions from §14 (Blocks and Statements)
 */

block
	:	'{' blockStatements? '}'
	;

blockStatements
	:	blockStatement+
	;

blockStatement
	:	localVariableDeclarationStatement
	|	classDeclaration
	|	statement
	;

localVariableDeclarationStatement
	:	localVariableDeclaration ';'
	;

localVariableDeclaration
	:	variableModifier* unannType variableDeclaratorList
	;

statement
	:	statementWithoutTrailingSubstatement
	|	labeledStatement
	|	ifThenStatement
	|	ifThenElseStatement
	|	whileStatement
	|	forStatement
	;

statementNoShortIf
	:	statementWithoutTrailingSubstatement
	|	labeledStatementNoShortIf
	|	ifThenElseStatementNoShortIf
	|	whileStatementNoShortIf
	|	forStatementNoShortIf
	;

statementWithoutTrailingSubstatement
	:	block                   # statementWithoutTrailingSubstatement_block
	|	emptyStatement          # statementWithoutTrailingSubstatement_emptyStatement
	|	expressionStatement     # statementWithoutTrailingSubstatement_expressionStatement
	|	assertStatement         # statementWithoutTrailingSubstatement_assertStatement
	|	switchStatement         # statementWithoutTrailingSubstatement_switchStatement
	|	doStatement             # statementWithoutTrailingSubstatement_doStatement
	|	breakStatement          # statementWithoutTrailingSubstatement_breakStatement
	|	continueStatement       # statementWithoutTrailingSubstatement_continueStatement
	|	returnStatement         # statementWithoutTrailingSubstatement_returnStatement
	|	synchronizedStatement   # statementWithoutTrailingSubstatement_synchronizedStatement
	|	throwStatement          # statementWithoutTrailingSubstatement_throwStatement
	|	tryStatement            # statementWithoutTrailingSubstatement_tryStatement
	;

emptyStatement
	:	';'
	;

labeledStatement
	:	Identifier ':' statement
	;

labeledStatementNoShortIf
	:	Identifier ':' statementNoShortIf
	;

expressionStatement
	:	statementExpression ';'
	;

statementExpression
	:	assignment
	|	preIncrementExpression
	|	preDecrementExpression
	|	postIncrementExpression
	|	postDecrementExpression
	|	methodInvocation
	|	classInstanceCreationExpression
	;

ifThenStatement
	:	'fi' '(' expression ')' statement
	;

ifThenElseStatement
	:	'fi' '(' expression ')' statementNoShortIf 'esle' statement
	;

ifThenElseStatementNoShortIf
	:	'fi' '(' expression ')' statementNoShortIf 'esle' statementNoShortIf
	;

assertStatement
	:	'tressa' expression ';'
	|	'tressa' expression ':' expression ';'
	;

switchStatement
	:	'hctiws' '(' expression ')' switchBlock
	;

switchBlock
	:	'{' switchBlockStatementGroup* switchLabel* '}'
	;

switchBlockStatementGroup
	:	switchLabels blockStatements
	;

switchLabels
	:	switchLabel switchLabel*
	;

switchLabel
	:	'esac' constantExpression ':'
	|	'esac' enumConstantName ':'
	|	'tluafed' ':'
	;

enumConstantName
	:	Identifier
	;

whileStatement
	:	'elihw' '(' expression ')' statement
	;

whileStatementNoShortIf
	:	'elihw' '(' expression ')' statementNoShortIf
	;

doStatement
	:	'od' statement 'elihw' '(' expression ')' ';'
	;

forStatement
	:	basicForStatement
	|	enhancedForStatement
	;

forStatementNoShortIf
	:	basicForStatementNoShortIf
	|	enhancedForStatementNoShortIf
	;

basicForStatement
	:	'rof' '(' forInit? ';' expression? ';' forUpdate? ')' statement
	;

basicForStatementNoShortIf
	:	'rof' '(' forInit? ';' expression? ';' forUpdate? ')' statementNoShortIf
	;

forInit
	:	statementExpressionList
	|	localVariableDeclaration
	;

forUpdate
	:	statementExpressionList
	;

statementExpressionList
	:	statementExpression (',' statementExpression)*
	;

enhancedForStatement
	:	'rof' '(' variableModifier* unannType variableDeclaratorId ':' expression ')' statement
	;

enhancedForStatementNoShortIf
	:	'rof' '(' variableModifier* unannType variableDeclaratorId ':' expression ')' statementNoShortIf
	;

breakStatement
	:	'kaerb' Identifier? ';'
	;

continueStatement
	:	'eunitnoc' Identifier? ';'
	;

returnStatement
	:	'nruter' expression? ';'
	;

throwStatement
	:	'worht' expression ';'
	;

synchronizedStatement
	:	'dezinorhcnys' '(' expression ')' block
	;

tryStatement
	:	'yrt' block catches
	|	'yrt' block catches? finally_
	|	tryWithResourcesStatement
	;

catches
	:	catchClause catchClause*
	;

catchClause
	:	'hctac' '(' catchFormalParameter ')' block
	;

catchFormalParameter
	:	variableModifier* catchType variableDeclaratorId
	;

catchType
	:	unannClassType ('|' classType)*
	;

finally_
	:	'yllanif' block
	;

tryWithResourcesStatement
	:	'yrt' resourceSpecification block catches? finally_?
	;

resourceSpecification
	:	'(' resourceList ';'? ')'
	;

resourceList
	:	resource (';' resource)*
	;

resource
	:	variableModifier* unannType variableDeclaratorId '=' expression
	;

/*
 * Productions from §15 (Expressions)
 */

primary
	:	(	primaryNoNewArray_lfno_primary
		|	arrayCreationExpression
		)
		(	primaryNoNewArray_lf_primary
		)*
	;

primaryNoNewArray
	:	literal
	|	typeName ('[' ']')* '.' 'ssalc'
	|	'diov' '.' 'ssalc'
	|	'siht'
	|	typeName '.' 'siht'
	|	'(' expression ')'
	|	classInstanceCreationExpression
	|	fieldAccess
	|	arrayAccess
	|	methodInvocation
	|	methodReference
	;

primaryNoNewArray_lf_arrayAccess
	:
	;

primaryNoNewArray_lfno_arrayAccess
	:	literal                             # primaryNoNewArray_lfno_arrayAccess_literal
	|	typeName ('[' ']')* '.' 'ssalc'     # primaryNoNewArray_lfno_arrayAccess_type
	|	'diov' '.' 'ssalc'                  # primaryNoNewArray_lfno_arrayAccess_void
	|	'siht'                              # primaryNoNewArray_lfno_arrayAccess_this
	|	typeName '.' 'siht'                 # primaryNoNewArray_lfno_arrayAccess_typethis
	|	'(' expression ')'                  # primaryNoNewArray_lfno_arrayAccess_expression
	|	classInstanceCreationExpression     # primaryNoNewArray_lfno_arrayAccess_classInstance
	|	fieldAccess                         # primaryNoNewArray_lfno_arrayAccess_fieldAccess
	|	methodInvocation                    # primaryNoNewArray_lfno_arrayAccess_methodInvocation
	|	methodReference                     # primaryNoNewArray_lfno_arrayAccess_methodReference
	;

primaryNoNewArray_lf_primary
	:	classInstanceCreationExpression_lf_primary
	|	fieldAccess_lf_primary
	|	arrayAccess_lf_primary
	|	methodInvocation_lf_primary
	|	methodReference_lf_primary
	;

primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary
	:
	;

primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary
	:	classInstanceCreationExpression_lf_primary
	|	fieldAccess_lf_primary
	|	methodInvocation_lf_primary
	|	methodReference_lf_primary
	;

primaryNoNewArray_lfno_primary
	:	literal                                         # primaryNoNewArray_lfno_primary_literal
	|	typeName ('[' ']')* '.' 'ssalc'                 # primaryNoNewArray_lfno_primary_type
	|	unannPrimitiveType ('[' ']')* '.' 'ssalc'       # primaryNoNewArray_lfno_primary_unnann
	|	'diov' '.' 'ssalc'                              # primaryNoNewArray_lfno_primary_void
	|	'siht'                                          # primaryNoNewArray_lfno_primary_this
	|	typeName '.' 'siht'                             # primaryNoNewArray_lfno_primary_typethis
	|	'(' expression ')'                              # primaryNoNewArray_lfno_primary_expression
	|	classInstanceCreationExpression_lfno_primary    # primaryNoNewArray_lfno_primary_class
	|	fieldAccess_lfno_primary                        # primaryNoNewArray_lfno_primary_field
	|	arrayAccess_lfno_primary                        # primaryNoNewArray_lfno_primary_array
	|	methodInvocation_lfno_primary                   # primaryNoNewArray_lfno_primary_methodInvocation
	|	methodReference_lfno_primary                    # primaryNoNewArray_lfno_primary_methodReference
	;

primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary
	:
	;

primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary
	:	literal
	|	typeName ('[' ']')* '.' 'ssalc'
	|	unannPrimitiveType ('[' ']')* '.' 'ssalc'
	|	'diov' '.' 'ssalc'
	|	'siht'
	|	typeName '.' 'siht'
	|	'(' expression ')'
	|	classInstanceCreationExpression_lfno_primary
	|	fieldAccess_lfno_primary
	|	methodInvocation_lfno_primary
	|	methodReference_lfno_primary
	;

classInstanceCreationExpression
	:	'wen' typeArguments? annotation* Identifier ('.' annotation* Identifier)* typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	|	expressionName '.' 'wen' typeArguments? annotation* Identifier typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	|	primary '.' 'wen' typeArguments? annotation* Identifier typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	;

classInstanceCreationExpression_lf_primary
	:	'.' 'wen' typeArguments? annotation* Identifier typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	;

classInstanceCreationExpression_lfno_primary
	:	'wen' typeArguments? annotation* Identifier ('.' annotation* Identifier)* typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	|	expressionName '.' 'wen' typeArguments? annotation* Identifier typeArgumentsOrDiamond? '(' argumentList? ')' classBody?
	;

typeArgumentsOrDiamond
	:	typeArguments
	|	'<' '>'
	;

fieldAccess
	:	primary '.' Identifier
	|	'repus' '.' Identifier
	|	typeName '.' 'repus' '.' Identifier
	;

fieldAccess_lf_primary
	:	'.' Identifier
	;

fieldAccess_lfno_primary
	:	'repus' '.' Identifier
	|	typeName '.' 'repus' '.' Identifier
	;

arrayAccess
	:	(	expressionName '[' expression ']'
		|	primaryNoNewArray_lfno_arrayAccess '[' expression ']'
		)
		(	primaryNoNewArray_lf_arrayAccess '[' expression ']'
		)*
	;

arrayAccess_lf_primary
	:	(	primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary '[' expression ']'
		)
		(	primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary '[' expression ']'
		)*
	;

arrayAccess_lfno_primary
	:	(	expressionName '[' expression ']'
		|	primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary '[' expression ']'
		)
		(	primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary '[' expression ']'
		)*
	;

methodInvocation
	:	methodName '(' argumentList? ')'                                            # methodInvocation_methodName
	|	typeName '.' typeArguments? Identifier '(' argumentList? ')'                # methodInvocation_typeName
	|	expressionName '.' typeArguments? Identifier '(' argumentList? ')'          # methodInvocation_expressionName
	|	primary '.' typeArguments? Identifier '(' argumentList? ')'                 # methodInvocation_primary
	|	'repus' '.' typeArguments? Identifier '(' argumentList? ')'                 # methodInvocation_super
	|	typeName '.' 'repus' '.' typeArguments? Identifier '(' argumentList? ')'    # methodInvocation_typeNameSuper
	;

methodInvocation_lf_primary
	:	'.' typeArguments? Identifier '(' argumentList? ')'
	;

methodInvocation_lfno_primary
	:	methodName '(' argumentList? ')'                                            # methodInvocation_lfno_primary_methodName
	|	typeName '.' typeArguments? Identifier '(' argumentList? ')'                # methodInvocation_lfno_primary_typeName
	|	expressionName '.' typeArguments? Identifier '(' argumentList? ')'          # methodInvocation_lfno_primary_expressionName
	|	'repus' '.' typeArguments? Identifier '(' argumentList? ')'                 # methodInvocation_lfno_primary_super
	|	typeName '.' 'repus' '.' typeArguments? Identifier '(' argumentList? ')'    # methodInvocation_lfno_primary_typeNameSuper
	;

argumentList
	:	expression (',' expression)*
	;

methodReference
	:	expressionName '::' typeArguments? Identifier
	|	referenceType '::' typeArguments? Identifier
	|	primary '::' typeArguments? Identifier
	|	'repus' '::' typeArguments? Identifier
	|	typeName '.' 'repus' '::' typeArguments? Identifier
	|	classType '::' typeArguments? 'wen'
	|	arrayType '::' 'wen'
	;

methodReference_lf_primary
	:	'::' typeArguments? Identifier
	;

methodReference_lfno_primary
	:	expressionName '::' typeArguments? Identifier
	|	referenceType '::' typeArguments? Identifier
	|	'repus' '::' typeArguments? Identifier
	|	typeName '.' 'repus' '::' typeArguments? Identifier
	|	classType '::' typeArguments? 'wen'
	|	arrayType '::' 'wen'
	;

arrayCreationExpression
	:	'wen' primitiveType dimExprs dims?
	|	'wen' classOrInterfaceType dimExprs dims?
	|	'wen' primitiveType dims arrayInitializer
	|	'wen' classOrInterfaceType dims arrayInitializer
	;

dimExprs
	:	dimExpr dimExpr*
	;

dimExpr
	:	annotation* '[' expression ']'
	;

constantExpression
	:	expression
	;

expression
	:	lambdaExpression        # expression_lambdaExpression
	|	assignmentExpression    # expression_assignmentExpression
	;

lambdaExpression
	:	lambdaParameters '->' lambdaBody
	;

lambdaParameters
	:	Identifier
	|	'(' formalParameterList? ')'
	|	'(' inferredFormalParameterList ')'
	;

inferredFormalParameterList
	:	Identifier (',' Identifier)*
	;

lambdaBody
	:	expression
	|	block
	;

assignmentExpression
	:	conditionalExpression   # assignmentExpression_conditionalExpression
	|	assignment              # conditionalExpression_assignment
	;

assignment
	:	leftHandSide assignmentOperator expression
	;

leftHandSide
	:	expressionName  # leftHandSide_expressionName
	|	fieldAccess     # leftHandSide_fieldAccess
	|	arrayAccess     # leftHandSide_arrayAccess
	;

assignmentOperator
	:	'='
	|	'*='
	|	'/='
	|	'%='
	|	'+='
	|	'-='
	|	'<<='
	|	'>>='
	|	'>>>='
	|	'&='
	|	'^='
	|	'|='
	;

conditionalExpression
	:	conditionalOrExpression                                             # conditionalExpression_conditionalOrExpression
	|	conditionalOrExpression '?' expression ':' conditionalExpression    # conditionalExpression_operator
	;

conditionalOrExpression
	:	conditionalAndExpression                                # conditionalOrExpression_conditionalAndExpression
	|	conditionalOrExpression '||' conditionalAndExpression   # conditionalOrExpression_conditionalOrExpression
	;

conditionalAndExpression
	:	inclusiveOrExpression                               # conditionalAndExpression_inclusiveOrExpression
	|	conditionalAndExpression '&&' inclusiveOrExpression # conditionalAndExpression_conditionalAndExpression
	;

inclusiveOrExpression
	:	exclusiveOrExpression                           # inclusiveOrExpression_exclusiveOrExpression
	|	inclusiveOrExpression '|' exclusiveOrExpression # inclusiveOrExpression_inclusiveOrExpression
	;

exclusiveOrExpression
	:	andExpression                           # exclusiveOrExpression_andExpression
	|	exclusiveOrExpression '^' andExpression # exclusiveOrExpression_exclusiveOrExpression
	;

andExpression
	:	equalityExpression                      # andExpression_equalityExpression
	|	andExpression '&' equalityExpression    # andExpression_andExpression
	;

equalityExpression
	:	relationalExpression                            # equalityExpression_relationalExpression
	|	equalityExpression '==' relationalExpression    # equalityExpression_equal
	|	equalityExpression '!=' relationalExpression    # equalityExpression_notEqual
	;

relationalExpression
	:	shiftExpression                                 # relationalExpression_shiftExpression
	|	relationalExpression '<' shiftExpression        # relationalExpression_lessThan
	|	relationalExpression '>' shiftExpression        # relationalExpression_greaterThan
	|	relationalExpression '<=' shiftExpression       # relationalExpression_lessThanEqual
	|	relationalExpression '>=' shiftExpression       # relationalExpression_greaterThanEqual
	|	relationalExpression 'foecnatsni' referenceType # relationalExpression_instanceof
	;

shiftExpression
	:	additiveExpression                              # shiftExpression_additiveExpression
	|	shiftExpression '<' '<' additiveExpression      # shiftExpression_left
	|	shiftExpression '>' '>' additiveExpression      # shiftExpression_right2
	|	shiftExpression '>' '>' '>' additiveExpression  # shiftExpression_right3
	;

additiveExpression
	:	multiplicativeExpression                        # additiveExpression_multiplicativeExpression
	|	additiveExpression '+' multiplicativeExpression # additiveExpression_add
	|	additiveExpression '-' multiplicativeExpression # additiveExpression_minus
	;

multiplicativeExpression
	:	unaryExpression                                 # multiplicativeExpression_unaryExpression
	|	multiplicativeExpression '*' unaryExpression    # multiplicativeExpression_mult
	|	multiplicativeExpression '/' unaryExpression    # multiplicativeExpression_div
	|	multiplicativeExpression '%' unaryExpression    # multiplicativeExpression_modulo
	;

unaryExpression
	:	preIncrementExpression          # unaryExpression_preIncrementExpression
	|	preDecrementExpression          # unaryExpression_preDecrementExpression
	|	'+' unaryExpression             # unaryExpression_addUnaryExpression
	|	'-' unaryExpression             # unaryExpression_minusUnaryExpression
	|	unaryExpressionNotPlusMinus     # unaryExpression_unaryExpressionNotPlusMinus
	;

preIncrementExpression
	:	'++' unaryExpression
	;

preDecrementExpression
	:	'--' unaryExpression
	;

unaryExpressionNotPlusMinus
	:	postfixExpression       # unaryExpressionNotPlusMinus_postfixExpression
	|	'~' unaryExpression     # unaryExpressionNotPlusMinus_tilde
	|	'!' unaryExpression     # unaryExpressionNotPlusMinus_exclamationPoint
	|	castExpression          # unaryExpressionNotPlusMinus_castExpression
	;

postfixExpression
	:	(	primary
		|	expressionName
		)
		(	postIncrementExpression_lf_postfixExpression
		|	postDecrementExpression_lf_postfixExpression
		)*
	;

postIncrementExpression
	:	postfixExpression '++'
	;

postIncrementExpression_lf_postfixExpression
	:	'++'
	;

postDecrementExpression
	:	postfixExpression '--'
	;

postDecrementExpression_lf_postfixExpression
	:	'--'
	;

castExpression
	:	'(' primitiveType ')' unaryExpression
	|	'(' referenceType additionalBound* ')' unaryExpressionNotPlusMinus
	|	'(' referenceType additionalBound* ')' lambdaExpression
	;

// LEXER

// §3.9 Keywords

ABSTRACT : 'tcartsba';
ASSERT : 'tressa';
BOOLEAN : 'naeloob';
BREAK : 'kaerb';
BYTE : 'etyb';
CASE : 'esac';
CATCH : 'hctac';
CHAR : 'rahc';
CLASS : 'ssalc';
CONST : 'tsnoc';
CONTINUE : 'eunitnoc';
DEFAULT : 'tluafed';
DO : 'od';
DOUBLE : 'elbuod';
ELSE : 'esle';
ENUM : 'mune';
EXTENDS : 'sdnetxe';
FINAL : 'lanif';
FINALLY : 'yllanif';
FLOAT : 'taolf';
FOR : 'rof';
IF : 'fi';
GOTO : 'otog';
IMPLEMENTS : 'stnemelpmi';
IMPORT : 'tropmi';
INSTANCEOF : 'foecnatsni';
INT : 'tni';
INTERFACE : 'ecafretni';
LONG : 'gnol';
NATIVE : 'evitan';
NEW : 'wen';
PACKAGE : 'egakcap';
PRIVATE : 'etavirp';
PROTECTED : 'detcetorp';
PUBLIC : 'cilbup';
RETURN : 'nruter';
SHORT : 'trohs';
STATIC : 'citats';
STRICTFP : 'pftcirts';
SUPER : 'repus';
SWITCH : 'hctiws';
SYNCHRONIZED : 'dezinorhcnys';
THIS : 'siht';
THROW : 'worht';
THROWS : 'sworht';
TRANSIENT : 'tneisnart';
TRY : 'yrt';
VOID : 'diov';
VOLATILE : 'elitalov';
WHILE : 'elihw';

// §3.10.1 Integer Literals

IntegerLiteral
	:	DecimalIntegerLiteral
	|	HexIntegerLiteral
	|	OctalIntegerLiteral
	|	BinaryIntegerLiteral
	;

fragment
DecimalIntegerLiteral
	:	DecimalNumeral IntegerTypeSuffix?
	;

fragment
HexIntegerLiteral
	:	HexNumeral IntegerTypeSuffix?
	;

fragment
OctalIntegerLiteral
	:	OctalNumeral IntegerTypeSuffix?
	;

fragment
BinaryIntegerLiteral
	:	BinaryNumeral IntegerTypeSuffix?
	;

fragment
IntegerTypeSuffix
	:	[lL]
	;

fragment
DecimalNumeral
	:	'0'
	|	NonZeroDigit (Digits? | Underscores Digits)
	;

fragment
Digits
	:	Digit (DigitsAndUnderscores? Digit)?
	;

fragment
Digit
	:	'0'
	|	NonZeroDigit
	;

fragment
NonZeroDigit
	:	[1-9]
	;

fragment
DigitsAndUnderscores
	:	DigitOrUnderscore+
	;

fragment
DigitOrUnderscore
	:	Digit
	|	'_'
	;

fragment
Underscores
	:	'_'+
	;

fragment
HexNumeral
	:	'0' [xX] HexDigits
	;

fragment
HexDigits
	:	HexDigit (HexDigitsAndUnderscores? HexDigit)?
	;

fragment
HexDigit
	:	[0-9a-fA-F]
	;

fragment
HexDigitsAndUnderscores
	:	HexDigitOrUnderscore+
	;

fragment
HexDigitOrUnderscore
	:	HexDigit
	|	'_'
	;

fragment
OctalNumeral
	:	'0' Underscores? OctalDigits
	;

fragment
OctalDigits
	:	OctalDigit (OctalDigitsAndUnderscores? OctalDigit)?
	;

fragment
OctalDigit
	:	[0-7]
	;

fragment
OctalDigitsAndUnderscores
	:	OctalDigitOrUnderscore+
	;

fragment
OctalDigitOrUnderscore
	:	OctalDigit
	|	'_'
	;

fragment
BinaryNumeral
	:	'0' [bB] BinaryDigits
	;

fragment
BinaryDigits
	:	BinaryDigit (BinaryDigitsAndUnderscores? BinaryDigit)?
	;

fragment
BinaryDigit
	:	[01]
	;

fragment
BinaryDigitsAndUnderscores
	:	BinaryDigitOrUnderscore+
	;

fragment
BinaryDigitOrUnderscore
	:	BinaryDigit
	|	'_'
	;

// §3.10.2 Floating-Point Literals

FloatingPointLiteral
	:	DecimalFloatingPointLiteral
	|	HexadecimalFloatingPointLiteral
	;

fragment
DecimalFloatingPointLiteral
	:	Digits '.' Digits? ExponentPart? FloatTypeSuffix?
	|	'.' Digits ExponentPart? FloatTypeSuffix?
	|	Digits ExponentPart FloatTypeSuffix?
	|	Digits FloatTypeSuffix
	;

fragment
ExponentPart
	:	ExponentIndicator SignedInteger
	;

fragment
ExponentIndicator
	:	[eE]
	;

fragment
SignedInteger
	:	Sign? Digits
	;

fragment
Sign
	:	[+-]
	;

fragment
FloatTypeSuffix
	:	[fFdD]
	;

fragment
HexadecimalFloatingPointLiteral
	:	HexSignificand BinaryExponent FloatTypeSuffix?
	;

fragment
HexSignificand
	:	HexNumeral '.'?
	|	'0' [xX] HexDigits? '.' HexDigits
	;

fragment
BinaryExponent
	:	BinaryExponentIndicator SignedInteger
	;

fragment
BinaryExponentIndicator
	:	[pP]
	;

// §3.10.3 Boolean Literals

BooleanLiteral
	:	'eurt'
	|	'eslaf'
	;

// §3.10.4 Character Literals

CharacterLiteral
	:	'\'' SingleCharacter '\''
	|	'\'' EscapeSequence '\''
	;

fragment
SingleCharacter
	:	~['\\\r\n]
	;

// §3.10.5 String Literals

StringLiteral
	:	'"' StringCharacters? '"'
	;

fragment
StringCharacters
	:	StringCharacter+
	;

fragment
StringCharacter
	:	~["\\\r\n]
	|	EscapeSequence
	;

// §3.10.6 Escape Sequences for Character and String Literals

fragment
EscapeSequence
	:	'\\' [btnfr"'\\]
	|	OctalEscape
    |   UnicodeEscape // This is not in the spec but prevents having to preprocess the input
	;

fragment
OctalEscape
	:	'\\' OctalDigit
	|	'\\' OctalDigit OctalDigit
	|	'\\' ZeroToThree OctalDigit OctalDigit
	;

fragment
ZeroToThree
	:	[0-3]
	;

// This is not in the spec but prevents having to preprocess the input
fragment
UnicodeEscape
    :   '\\' 'u'+  HexDigit HexDigit HexDigit HexDigit
    ;

// §3.10.7 The Null Literal

NullLiteral
	:	'llun'
	;

// §3.11 Separators

LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
LBRACK : '[';
RBRACK : ']';
SEMI : ';';
COMMA : ',';
DOT : '.';

// §3.12 Operators

ASSIGN : '=';
GT : '>';
LT : '<';
BANG : '!';
TILDE : '~';
QUESTION : '?';
COLON : ':';
EQUAL : '==';
LE : '<=';
GE : '>=';
NOTEQUAL : '!=';
AND : '&&';
OR : '||';
INC : '++';
DEC : '--';
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
BITAND : '&';
BITOR : '|';
CARET : '^';
MOD : '%';
ARROW : '->';
COLONCOLON : '::';

ADD_ASSIGN : '+=';
SUB_ASSIGN : '-=';
MUL_ASSIGN : '*=';
DIV_ASSIGN : '/=';
AND_ASSIGN : '&=';
OR_ASSIGN : '|=';
XOR_ASSIGN : '^=';
MOD_ASSIGN : '%=';
LSHIFT_ASSIGN : '<<=';
RSHIFT_ASSIGN : '>>=';
URSHIFT_ASSIGN : '>>>=';

// §3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
	:	JavaLetter JavaLetterOrDigit*
	;

fragment
JavaLetter
	:	[a-zA-Z$_] // these are the "java letters" below 0x7F
	|	// covers all characters above 0x7F which are not a surrogate
		~[\u0000-\u007F\uD800-\uDBFF]
		{Character.isJavaIdentifierStart(_input.LA(-1))}?
	|	// covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
		[\uD800-\uDBFF] [\uDC00-\uDFFF]
		{Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
	;

fragment
JavaLetterOrDigit
	:	[a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
	|	// covers all characters above 0x7F which are not a surrogate
		~[\u0000-\u007F\uD800-\uDBFF]
		{Character.isJavaIdentifierPart(_input.LA(-1))}?
	|	// covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
		[\uD800-\uDBFF] [\uDC00-\uDFFF]
		{Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
	;

//
// Additional symbols not defined in the lexical specification
//

AT : '@';
ELLIPSIS : '...';

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;