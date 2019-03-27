// Generated from D:\Documents\Graduate Studies\CSC617M\MP\git1\CSC617M_MachineProject\dyslexia\src\dyslexia\grammar\Dyslexia.g4 by ANTLR 4.5.3
package dyslexia.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DyslexiaParser}.
 */
public interface DyslexiaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(DyslexiaParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(DyslexiaParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatingPointLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointLiteral(DyslexiaParser.FloatingPointLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatingPointLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointLiteral(DyslexiaParser.FloatingPointLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(DyslexiaParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(DyslexiaParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharacterLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterCharacterLiteral(DyslexiaParser.CharacterLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharacterLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitCharacterLiteral(DyslexiaParser.CharacterLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(DyslexiaParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(DyslexiaParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(DyslexiaParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(DyslexiaParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(DyslexiaParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(DyslexiaParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericType_integralType}
	 * labeled alternative in {@link DyslexiaParser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType_integralType(DyslexiaParser.NumericType_integralTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericType_integralType}
	 * labeled alternative in {@link DyslexiaParser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType_integralType(DyslexiaParser.NumericType_integralTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericType_floatingPointType}
	 * labeled alternative in {@link DyslexiaParser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType_floatingPointType(DyslexiaParser.NumericType_floatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericType_floatingPointType}
	 * labeled alternative in {@link DyslexiaParser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType_floatingPointType(DyslexiaParser.NumericType_floatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(DyslexiaParser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(DyslexiaParser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(DyslexiaParser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(DyslexiaParser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(DyslexiaParser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(DyslexiaParser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(DyslexiaParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(DyslexiaParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(DyslexiaParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(DyslexiaParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassType_lf_classOrInterfaceType(DyslexiaParser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassType_lf_classOrInterfaceType(DyslexiaParser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassType_lfno_classOrInterfaceType(DyslexiaParser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassType_lfno_classOrInterfaceType(DyslexiaParser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType(DyslexiaParser.InterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType(DyslexiaParser.InterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType_lf_classOrInterfaceType(DyslexiaParser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType_lf_classOrInterfaceType(DyslexiaParser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType_lfno_classOrInterfaceType(DyslexiaParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType_lfno_classOrInterfaceType(DyslexiaParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariable(DyslexiaParser.TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariable(DyslexiaParser.TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(DyslexiaParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(DyslexiaParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(DyslexiaParser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(DyslexiaParser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(DyslexiaParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(DyslexiaParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterModifier(DyslexiaParser.TypeParameterModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterModifier(DyslexiaParser.TypeParameterModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(DyslexiaParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(DyslexiaParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void enterAdditionalBound(DyslexiaParser.AdditionalBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void exitAdditionalBound(DyslexiaParser.AdditionalBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(DyslexiaParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(DyslexiaParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentList(DyslexiaParser.TypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentList(DyslexiaParser.TypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(DyslexiaParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(DyslexiaParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#wildcard}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(DyslexiaParser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#wildcard}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(DyslexiaParser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void enterWildcardBounds(DyslexiaParser.WildcardBoundsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void exitWildcardBounds(DyslexiaParser.WildcardBoundsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(DyslexiaParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(DyslexiaParser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(DyslexiaParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(DyslexiaParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void enterPackageOrTypeName(DyslexiaParser.PackageOrTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void exitPackageOrTypeName(DyslexiaParser.PackageOrTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionName_Identifier}
	 * labeled alternative in {@link DyslexiaParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void enterExpressionName_Identifier(DyslexiaParser.ExpressionName_IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionName_Identifier}
	 * labeled alternative in {@link DyslexiaParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void exitExpressionName_Identifier(DyslexiaParser.ExpressionName_IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionName_ambiguousName}
	 * labeled alternative in {@link DyslexiaParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void enterExpressionName_ambiguousName(DyslexiaParser.ExpressionName_ambiguousNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionName_ambiguousName}
	 * labeled alternative in {@link DyslexiaParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void exitExpressionName_ambiguousName(DyslexiaParser.ExpressionName_ambiguousNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(DyslexiaParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(DyslexiaParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void enterAmbiguousName(DyslexiaParser.AmbiguousNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void exitAmbiguousName(DyslexiaParser.AmbiguousNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(DyslexiaParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(DyslexiaParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(DyslexiaParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(DyslexiaParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void enterPackageModifier(DyslexiaParser.PackageModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void exitPackageModifier(DyslexiaParser.PackageModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(DyslexiaParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(DyslexiaParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleTypeImportDeclaration(DyslexiaParser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleTypeImportDeclaration(DyslexiaParser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeImportOnDemandDeclaration(DyslexiaParser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeImportOnDemandDeclaration(DyslexiaParser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleStaticImportDeclaration(DyslexiaParser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleStaticImportDeclaration(DyslexiaParser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticImportOnDemandDeclaration(DyslexiaParser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticImportOnDemandDeclaration(DyslexiaParser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(DyslexiaParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(DyslexiaParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(DyslexiaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(DyslexiaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalClassDeclaration(DyslexiaParser.NormalClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalClassDeclaration(DyslexiaParser.NormalClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(DyslexiaParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(DyslexiaParser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(DyslexiaParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(DyslexiaParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterList(DyslexiaParser.TypeParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterList(DyslexiaParser.TypeParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#superclass}.
	 * @param ctx the parse tree
	 */
	void enterSuperclass(DyslexiaParser.SuperclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#superclass}.
	 * @param ctx the parse tree
	 */
	void exitSuperclass(DyslexiaParser.SuperclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void enterSuperinterfaces(DyslexiaParser.SuperinterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void exitSuperinterfaces(DyslexiaParser.SuperinterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypeList(DyslexiaParser.InterfaceTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypeList(DyslexiaParser.InterfaceTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(DyslexiaParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(DyslexiaParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(DyslexiaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(DyslexiaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classMemberDeclaration_fieldDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration_fieldDeclaration(DyslexiaParser.ClassMemberDeclaration_fieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classMemberDeclaration_fieldDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration_fieldDeclaration(DyslexiaParser.ClassMemberDeclaration_fieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classMemberDeclaration_methodDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration_methodDeclaration(DyslexiaParser.ClassMemberDeclaration_methodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classMemberDeclaration_methodDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration_methodDeclaration(DyslexiaParser.ClassMemberDeclaration_methodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classMemberDeclaration_classDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration_classDeclaration(DyslexiaParser.ClassMemberDeclaration_classDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classMemberDeclaration_classDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration_classDeclaration(DyslexiaParser.ClassMemberDeclaration_classDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classMemberDeclaration_interfaceDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration_interfaceDeclaration(DyslexiaParser.ClassMemberDeclaration_interfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classMemberDeclaration_interfaceDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration_interfaceDeclaration(DyslexiaParser.ClassMemberDeclaration_interfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classMemberDeclaration_semicolon}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration_semicolon(DyslexiaParser.ClassMemberDeclaration_semicolonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classMemberDeclaration_semicolon}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration_semicolon(DyslexiaParser.ClassMemberDeclaration_semicolonContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(DyslexiaParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(DyslexiaParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(DyslexiaParser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(DyslexiaParser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorList(DyslexiaParser.VariableDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorList(DyslexiaParser.VariableDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(DyslexiaParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(DyslexiaParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(DyslexiaParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(DyslexiaParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableInitializer_expression}
	 * labeled alternative in {@link DyslexiaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer_expression(DyslexiaParser.VariableInitializer_expressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableInitializer_expression}
	 * labeled alternative in {@link DyslexiaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer_expression(DyslexiaParser.VariableInitializer_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableInitializer_arrayInitializer}
	 * labeled alternative in {@link DyslexiaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer_arrayInitializer(DyslexiaParser.VariableInitializer_arrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableInitializer_arrayInitializer}
	 * labeled alternative in {@link DyslexiaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer_arrayInitializer(DyslexiaParser.VariableInitializer_arrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unannType_unannPrimitiveType}
	 * labeled alternative in {@link DyslexiaParser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType_unannPrimitiveType(DyslexiaParser.UnannType_unannPrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unannType_unannPrimitiveType}
	 * labeled alternative in {@link DyslexiaParser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType_unannPrimitiveType(DyslexiaParser.UnannType_unannPrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unannType_unannReferenceType}
	 * labeled alternative in {@link DyslexiaParser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType_unannReferenceType(DyslexiaParser.UnannType_unannReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unannType_unannReferenceType}
	 * labeled alternative in {@link DyslexiaParser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType_unannReferenceType(DyslexiaParser.UnannType_unannReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unannPrimitiveType_numericType}
	 * labeled alternative in {@link DyslexiaParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterUnannPrimitiveType_numericType(DyslexiaParser.UnannPrimitiveType_numericTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unannPrimitiveType_numericType}
	 * labeled alternative in {@link DyslexiaParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitUnannPrimitiveType_numericType(DyslexiaParser.UnannPrimitiveType_numericTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unannPrimitiveType_boolean}
	 * labeled alternative in {@link DyslexiaParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterUnannPrimitiveType_boolean(DyslexiaParser.UnannPrimitiveType_booleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unannPrimitiveType_boolean}
	 * labeled alternative in {@link DyslexiaParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitUnannPrimitiveType_boolean(DyslexiaParser.UnannPrimitiveType_booleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unannReferenceType_ClassOrInterfaceType}
	 * labeled alternative in {@link DyslexiaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannReferenceType_ClassOrInterfaceType(DyslexiaParser.UnannReferenceType_ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unannReferenceType_ClassOrInterfaceType}
	 * labeled alternative in {@link DyslexiaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannReferenceType_ClassOrInterfaceType(DyslexiaParser.UnannReferenceType_ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unannReferenceType_TypeVariable}
	 * labeled alternative in {@link DyslexiaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannReferenceType_TypeVariable(DyslexiaParser.UnannReferenceType_TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unannReferenceType_TypeVariable}
	 * labeled alternative in {@link DyslexiaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannReferenceType_TypeVariable(DyslexiaParser.UnannReferenceType_TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unannReferenceType_ArrayType}
	 * labeled alternative in {@link DyslexiaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannReferenceType_ArrayType(DyslexiaParser.UnannReferenceType_ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unannReferenceType_ArrayType}
	 * labeled alternative in {@link DyslexiaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannReferenceType_ArrayType(DyslexiaParser.UnannReferenceType_ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassOrInterfaceType(DyslexiaParser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassOrInterfaceType(DyslexiaParser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType(DyslexiaParser.UnannClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType(DyslexiaParser.UnannClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType_lf_unannClassOrInterfaceType(DyslexiaParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType_lf_unannClassOrInterfaceType(DyslexiaParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType_lfno_unannClassOrInterfaceType(DyslexiaParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType_lfno_unannClassOrInterfaceType(DyslexiaParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType(DyslexiaParser.UnannInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType(DyslexiaParser.UnannInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType_lf_unannClassOrInterfaceType(DyslexiaParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType_lf_unannClassOrInterfaceType(DyslexiaParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType_lfno_unannClassOrInterfaceType(DyslexiaParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType_lfno_unannClassOrInterfaceType(DyslexiaParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void enterUnannTypeVariable(DyslexiaParser.UnannTypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void exitUnannTypeVariable(DyslexiaParser.UnannTypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void enterUnannArrayType(DyslexiaParser.UnannArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void exitUnannArrayType(DyslexiaParser.UnannArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(DyslexiaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(DyslexiaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void enterMethodModifier(DyslexiaParser.MethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void exitMethodModifier(DyslexiaParser.MethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(DyslexiaParser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(DyslexiaParser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code result_unannType}
	 * labeled alternative in {@link DyslexiaParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult_unannType(DyslexiaParser.Result_unannTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code result_unannType}
	 * labeled alternative in {@link DyslexiaParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult_unannType(DyslexiaParser.Result_unannTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code result_void}
	 * labeled alternative in {@link DyslexiaParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult_void(DyslexiaParser.Result_voidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code result_void}
	 * labeled alternative in {@link DyslexiaParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult_void(DyslexiaParser.Result_voidContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(DyslexiaParser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(DyslexiaParser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code formalParameterList_receiverParameter}
	 * labeled alternative in {@link DyslexiaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList_receiverParameter(DyslexiaParser.FormalParameterList_receiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code formalParameterList_receiverParameter}
	 * labeled alternative in {@link DyslexiaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList_receiverParameter(DyslexiaParser.FormalParameterList_receiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code formalParameterList_formalParameters}
	 * labeled alternative in {@link DyslexiaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList_formalParameters(DyslexiaParser.FormalParameterList_formalParametersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code formalParameterList_formalParameters}
	 * labeled alternative in {@link DyslexiaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList_formalParameters(DyslexiaParser.FormalParameterList_formalParametersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code formalParameterList_lastFormalParameter}
	 * labeled alternative in {@link DyslexiaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList_lastFormalParameter(DyslexiaParser.FormalParameterList_lastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code formalParameterList_lastFormalParameter}
	 * labeled alternative in {@link DyslexiaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList_lastFormalParameter(DyslexiaParser.FormalParameterList_lastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(DyslexiaParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(DyslexiaParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(DyslexiaParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(DyslexiaParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableModifier_annotation}
	 * labeled alternative in {@link DyslexiaParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier_annotation(DyslexiaParser.VariableModifier_annotationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableModifier_annotation}
	 * labeled alternative in {@link DyslexiaParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier_annotation(DyslexiaParser.VariableModifier_annotationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableModifier_final}
	 * labeled alternative in {@link DyslexiaParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier_final(DyslexiaParser.VariableModifier_finalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableModifier_final}
	 * labeled alternative in {@link DyslexiaParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier_final(DyslexiaParser.VariableModifier_finalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(DyslexiaParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(DyslexiaParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void enterReceiverParameter(DyslexiaParser.ReceiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void exitReceiverParameter(DyslexiaParser.ReceiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#throws_}.
	 * @param ctx the parse tree
	 */
	void enterThrows_(DyslexiaParser.Throws_Context ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#throws_}.
	 * @param ctx the parse tree
	 */
	void exitThrows_(DyslexiaParser.Throws_Context ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void enterExceptionTypeList(DyslexiaParser.ExceptionTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void exitExceptionTypeList(DyslexiaParser.ExceptionTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void enterExceptionType(DyslexiaParser.ExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void exitExceptionType(DyslexiaParser.ExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(DyslexiaParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(DyslexiaParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void enterInstanceInitializer(DyslexiaParser.InstanceInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void exitInstanceInitializer(DyslexiaParser.InstanceInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void enterStaticInitializer(DyslexiaParser.StaticInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void exitStaticInitializer(DyslexiaParser.StaticInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(DyslexiaParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(DyslexiaParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstructorModifier(DyslexiaParser.ConstructorModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstructorModifier(DyslexiaParser.ConstructorModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclarator(DyslexiaParser.ConstructorDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclarator(DyslexiaParser.ConstructorDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeName(DyslexiaParser.SimpleTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeName(DyslexiaParser.SimpleTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(DyslexiaParser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(DyslexiaParser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitConstructorInvocation(DyslexiaParser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitConstructorInvocation(DyslexiaParser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(DyslexiaParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(DyslexiaParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(DyslexiaParser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(DyslexiaParser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantList(DyslexiaParser.EnumConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantList(DyslexiaParser.EnumConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(DyslexiaParser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(DyslexiaParser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantModifier(DyslexiaParser.EnumConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantModifier(DyslexiaParser.EnumConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(DyslexiaParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(DyslexiaParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(DyslexiaParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(DyslexiaParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalInterfaceDeclaration(DyslexiaParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalInterfaceDeclaration(DyslexiaParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceModifier(DyslexiaParser.InterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceModifier(DyslexiaParser.InterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#extendsInterfaces}.
	 * @param ctx the parse tree
	 */
	void enterExtendsInterfaces(DyslexiaParser.ExtendsInterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#extendsInterfaces}.
	 * @param ctx the parse tree
	 */
	void exitExtendsInterfaces(DyslexiaParser.ExtendsInterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(DyslexiaParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(DyslexiaParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(DyslexiaParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(DyslexiaParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(DyslexiaParser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(DyslexiaParser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstantModifier(DyslexiaParser.ConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstantModifier(DyslexiaParser.ConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(DyslexiaParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(DyslexiaParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodModifier(DyslexiaParser.InterfaceMethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodModifier(DyslexiaParser.InterfaceMethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(DyslexiaParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(DyslexiaParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(DyslexiaParser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(DyslexiaParser.AnnotationTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeMemberDeclaration(DyslexiaParser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeMemberDeclaration(DyslexiaParser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(DyslexiaParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(DyslexiaParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementModifier(DyslexiaParser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementModifier(DyslexiaParser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(DyslexiaParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(DyslexiaParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(DyslexiaParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(DyslexiaParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterNormalAnnotation(DyslexiaParser.NormalAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitNormalAnnotation(DyslexiaParser.NormalAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairList(DyslexiaParser.ElementValuePairListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairList(DyslexiaParser.ElementValuePairListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(DyslexiaParser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(DyslexiaParser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(DyslexiaParser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(DyslexiaParser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(DyslexiaParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(DyslexiaParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void enterElementValueList(DyslexiaParser.ElementValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void exitElementValueList(DyslexiaParser.ElementValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterMarkerAnnotation(DyslexiaParser.MarkerAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitMarkerAnnotation(DyslexiaParser.MarkerAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterSingleElementAnnotation(DyslexiaParser.SingleElementAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitSingleElementAnnotation(DyslexiaParser.SingleElementAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(DyslexiaParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(DyslexiaParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializerList(DyslexiaParser.VariableInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializerList(DyslexiaParser.VariableInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(DyslexiaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(DyslexiaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatements(DyslexiaParser.BlockStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatements(DyslexiaParser.BlockStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(DyslexiaParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(DyslexiaParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(DyslexiaParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(DyslexiaParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(DyslexiaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(DyslexiaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DyslexiaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DyslexiaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterStatementNoShortIf(DyslexiaParser.StatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitStatementNoShortIf(DyslexiaParser.StatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWithoutTrailingSubstatement(DyslexiaParser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWithoutTrailingSubstatement(DyslexiaParser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(DyslexiaParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(DyslexiaParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(DyslexiaParser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(DyslexiaParser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatementNoShortIf(DyslexiaParser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatementNoShortIf(DyslexiaParser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(DyslexiaParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(DyslexiaParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(DyslexiaParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(DyslexiaParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenStatement(DyslexiaParser.IfThenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenStatement(DyslexiaParser.IfThenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatement(DyslexiaParser.IfThenElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatement(DyslexiaParser.IfThenElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatementNoShortIf(DyslexiaParser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatementNoShortIf(DyslexiaParser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(DyslexiaParser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(DyslexiaParser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(DyslexiaParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(DyslexiaParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlock(DyslexiaParser.SwitchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlock(DyslexiaParser.SwitchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(DyslexiaParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(DyslexiaParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#switchLabels}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabels(DyslexiaParser.SwitchLabelsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#switchLabels}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabels(DyslexiaParser.SwitchLabelsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(DyslexiaParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(DyslexiaParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantName(DyslexiaParser.EnumConstantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantName(DyslexiaParser.EnumConstantNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(DyslexiaParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(DyslexiaParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatementNoShortIf(DyslexiaParser.WhileStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatementNoShortIf(DyslexiaParser.WhileStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(DyslexiaParser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(DyslexiaParser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(DyslexiaParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(DyslexiaParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterForStatementNoShortIf(DyslexiaParser.ForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitForStatementNoShortIf(DyslexiaParser.ForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatement(DyslexiaParser.BasicForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatement(DyslexiaParser.BasicForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatementNoShortIf(DyslexiaParser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatementNoShortIf(DyslexiaParser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(DyslexiaParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(DyslexiaParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(DyslexiaParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(DyslexiaParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionList(DyslexiaParser.StatementExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionList(DyslexiaParser.StatementExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatement(DyslexiaParser.EnhancedForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatement(DyslexiaParser.EnhancedForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatementNoShortIf(DyslexiaParser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatementNoShortIf(DyslexiaParser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(DyslexiaParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(DyslexiaParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(DyslexiaParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(DyslexiaParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(DyslexiaParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(DyslexiaParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(DyslexiaParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(DyslexiaParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizedStatement(DyslexiaParser.SynchronizedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizedStatement(DyslexiaParser.SynchronizedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(DyslexiaParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(DyslexiaParser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#catches}.
	 * @param ctx the parse tree
	 */
	void enterCatches(DyslexiaParser.CatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#catches}.
	 * @param ctx the parse tree
	 */
	void exitCatches(DyslexiaParser.CatchesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(DyslexiaParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(DyslexiaParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterCatchFormalParameter(DyslexiaParser.CatchFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitCatchFormalParameter(DyslexiaParser.CatchFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(DyslexiaParser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(DyslexiaParser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#finally_}.
	 * @param ctx the parse tree
	 */
	void enterFinally_(DyslexiaParser.Finally_Context ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#finally_}.
	 * @param ctx the parse tree
	 */
	void exitFinally_(DyslexiaParser.Finally_Context ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryWithResourcesStatement(DyslexiaParser.TryWithResourcesStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryWithResourcesStatement(DyslexiaParser.TryWithResourcesStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(DyslexiaParser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(DyslexiaParser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#resourceList}.
	 * @param ctx the parse tree
	 */
	void enterResourceList(DyslexiaParser.ResourceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#resourceList}.
	 * @param ctx the parse tree
	 */
	void exitResourceList(DyslexiaParser.ResourceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(DyslexiaParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(DyslexiaParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(DyslexiaParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(DyslexiaParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray(DyslexiaParser.PrimaryNoNewArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray(DyslexiaParser.PrimaryNoNewArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_arrayAccess(DyslexiaParser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_arrayAccess(DyslexiaParser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_literal}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess_literal(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_literalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_literal}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess_literal(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_literalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_type}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess_type(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_type}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess_type(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_void}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess_void(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_voidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_void}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess_void(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_voidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_this}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess_this(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_thisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_this}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess_this(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_thisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_typethis}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess_typethis(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_typethisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_typethis}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess_typethis(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_typethisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_expression}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess_expression(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_expressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_expression}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess_expression(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_classInstance}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess_classInstance(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_classInstanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_classInstance}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess_classInstance(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_classInstanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_fieldAccess}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess_fieldAccess(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_fieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_fieldAccess}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess_fieldAccess(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_fieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_methodInvocation}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess_methodInvocation(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_methodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_methodInvocation}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess_methodInvocation(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_methodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_methodReference}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess_methodReference(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_methodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_methodReference}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess_methodReference(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_methodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary(DyslexiaParser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary(DyslexiaParser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(DyslexiaParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(DyslexiaParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(DyslexiaParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(DyslexiaParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_literal}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_literal(DyslexiaParser.PrimaryNoNewArray_lfno_primary_literalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_literal}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_literal(DyslexiaParser.PrimaryNoNewArray_lfno_primary_literalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_type}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_type(DyslexiaParser.PrimaryNoNewArray_lfno_primary_typeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_type}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_type(DyslexiaParser.PrimaryNoNewArray_lfno_primary_typeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_unnann}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_unnann(DyslexiaParser.PrimaryNoNewArray_lfno_primary_unnannContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_unnann}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_unnann(DyslexiaParser.PrimaryNoNewArray_lfno_primary_unnannContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_void}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_void(DyslexiaParser.PrimaryNoNewArray_lfno_primary_voidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_void}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_void(DyslexiaParser.PrimaryNoNewArray_lfno_primary_voidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_this}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_this(DyslexiaParser.PrimaryNoNewArray_lfno_primary_thisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_this}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_this(DyslexiaParser.PrimaryNoNewArray_lfno_primary_thisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_typethis}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_typethis(DyslexiaParser.PrimaryNoNewArray_lfno_primary_typethisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_typethis}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_typethis(DyslexiaParser.PrimaryNoNewArray_lfno_primary_typethisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_expression}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_expression(DyslexiaParser.PrimaryNoNewArray_lfno_primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_expression}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_expression(DyslexiaParser.PrimaryNoNewArray_lfno_primary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_class}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_class(DyslexiaParser.PrimaryNoNewArray_lfno_primary_classContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_class}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_class(DyslexiaParser.PrimaryNoNewArray_lfno_primary_classContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_field}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_field(DyslexiaParser.PrimaryNoNewArray_lfno_primary_fieldContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_field}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_field(DyslexiaParser.PrimaryNoNewArray_lfno_primary_fieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_array}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_array(DyslexiaParser.PrimaryNoNewArray_lfno_primary_arrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_array}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_array(DyslexiaParser.PrimaryNoNewArray_lfno_primary_arrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_methodInvocation}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_methodInvocation(DyslexiaParser.PrimaryNoNewArray_lfno_primary_methodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_methodInvocation}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_methodInvocation(DyslexiaParser.PrimaryNoNewArray_lfno_primary_methodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryNoNewArray_lfno_primary_methodReference}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_methodReference(DyslexiaParser.PrimaryNoNewArray_lfno_primary_methodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_methodReference}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_methodReference(DyslexiaParser.PrimaryNoNewArray_lfno_primary_methodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(DyslexiaParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(DyslexiaParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(DyslexiaParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(DyslexiaParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression(DyslexiaParser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression(DyslexiaParser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression_lf_primary(DyslexiaParser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression_lf_primary(DyslexiaParser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression_lfno_primary(DyslexiaParser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression_lfno_primary(DyslexiaParser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(DyslexiaParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(DyslexiaParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(DyslexiaParser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(DyslexiaParser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess_lf_primary(DyslexiaParser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess_lf_primary(DyslexiaParser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess_lfno_primary(DyslexiaParser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess_lfno_primary(DyslexiaParser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(DyslexiaParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(DyslexiaParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess_lf_primary(DyslexiaParser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess_lf_primary(DyslexiaParser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess_lfno_primary(DyslexiaParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess_lfno_primary(DyslexiaParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodInvocation_methodName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_methodName(DyslexiaParser.MethodInvocation_methodNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodInvocation_methodName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_methodName(DyslexiaParser.MethodInvocation_methodNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodInvocation_typeName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_typeName(DyslexiaParser.MethodInvocation_typeNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodInvocation_typeName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_typeName(DyslexiaParser.MethodInvocation_typeNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodInvocation_expressionName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_expressionName(DyslexiaParser.MethodInvocation_expressionNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodInvocation_expressionName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_expressionName(DyslexiaParser.MethodInvocation_expressionNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodInvocation_primary}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_primary(DyslexiaParser.MethodInvocation_primaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodInvocation_primary}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_primary(DyslexiaParser.MethodInvocation_primaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodInvocation_super}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_super(DyslexiaParser.MethodInvocation_superContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodInvocation_super}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_super(DyslexiaParser.MethodInvocation_superContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodInvocation_typeNameSuper}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_typeNameSuper(DyslexiaParser.MethodInvocation_typeNameSuperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodInvocation_typeNameSuper}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_typeNameSuper(DyslexiaParser.MethodInvocation_typeNameSuperContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lf_primary(DyslexiaParser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lf_primary(DyslexiaParser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodInvocation_lfno_primary_methodName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lfno_primary_methodName(DyslexiaParser.MethodInvocation_lfno_primary_methodNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodInvocation_lfno_primary_methodName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lfno_primary_methodName(DyslexiaParser.MethodInvocation_lfno_primary_methodNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodInvocation_lfno_primary_typeName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lfno_primary_typeName(DyslexiaParser.MethodInvocation_lfno_primary_typeNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodInvocation_lfno_primary_typeName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lfno_primary_typeName(DyslexiaParser.MethodInvocation_lfno_primary_typeNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodInvocation_lfno_primary_expressionName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lfno_primary_expressionName(DyslexiaParser.MethodInvocation_lfno_primary_expressionNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodInvocation_lfno_primary_expressionName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lfno_primary_expressionName(DyslexiaParser.MethodInvocation_lfno_primary_expressionNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodInvocation_lfno_primary_super}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lfno_primary_super(DyslexiaParser.MethodInvocation_lfno_primary_superContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodInvocation_lfno_primary_super}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lfno_primary_super(DyslexiaParser.MethodInvocation_lfno_primary_superContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodInvocation_lfno_primary_typeNameSuper}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lfno_primary_typeNameSuper(DyslexiaParser.MethodInvocation_lfno_primary_typeNameSuperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodInvocation_lfno_primary_typeNameSuper}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lfno_primary_typeNameSuper(DyslexiaParser.MethodInvocation_lfno_primary_typeNameSuperContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(DyslexiaParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(DyslexiaParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#methodReference}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference(DyslexiaParser.MethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#methodReference}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference(DyslexiaParser.MethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference_lf_primary(DyslexiaParser.MethodReference_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference_lf_primary(DyslexiaParser.MethodReference_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference_lfno_primary(DyslexiaParser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference_lfno_primary(DyslexiaParser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpression(DyslexiaParser.ArrayCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpression(DyslexiaParser.ArrayCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void enterDimExprs(DyslexiaParser.DimExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void exitDimExprs(DyslexiaParser.DimExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void enterDimExpr(DyslexiaParser.DimExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void exitDimExpr(DyslexiaParser.DimExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(DyslexiaParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(DyslexiaParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expression_lambdaExpression}
	 * labeled alternative in {@link DyslexiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression_lambdaExpression(DyslexiaParser.Expression_lambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expression_lambdaExpression}
	 * labeled alternative in {@link DyslexiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression_lambdaExpression(DyslexiaParser.Expression_lambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expression_assignmentExpression}
	 * labeled alternative in {@link DyslexiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression_assignmentExpression(DyslexiaParser.Expression_assignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expression_assignmentExpression}
	 * labeled alternative in {@link DyslexiaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression_assignmentExpression(DyslexiaParser.Expression_assignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(DyslexiaParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(DyslexiaParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(DyslexiaParser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(DyslexiaParser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterInferredFormalParameterList(DyslexiaParser.InferredFormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitInferredFormalParameterList(DyslexiaParser.InferredFormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(DyslexiaParser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(DyslexiaParser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentExpression_conditionalExpression}
	 * labeled alternative in {@link DyslexiaParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression_conditionalExpression(DyslexiaParser.AssignmentExpression_conditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentExpression_conditionalExpression}
	 * labeled alternative in {@link DyslexiaParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression_conditionalExpression(DyslexiaParser.AssignmentExpression_conditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpression_assignment}
	 * labeled alternative in {@link DyslexiaParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression_assignment(DyslexiaParser.ConditionalExpression_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpression_assignment}
	 * labeled alternative in {@link DyslexiaParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression_assignment(DyslexiaParser.ConditionalExpression_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(DyslexiaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(DyslexiaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leftHandSide_expressionName}
	 * labeled alternative in {@link DyslexiaParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide_expressionName(DyslexiaParser.LeftHandSide_expressionNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leftHandSide_expressionName}
	 * labeled alternative in {@link DyslexiaParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide_expressionName(DyslexiaParser.LeftHandSide_expressionNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leftHandSide_fieldAccess}
	 * labeled alternative in {@link DyslexiaParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide_fieldAccess(DyslexiaParser.LeftHandSide_fieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leftHandSide_fieldAccess}
	 * labeled alternative in {@link DyslexiaParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide_fieldAccess(DyslexiaParser.LeftHandSide_fieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leftHandSide_arrayAccess}
	 * labeled alternative in {@link DyslexiaParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide_arrayAccess(DyslexiaParser.LeftHandSide_arrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leftHandSide_arrayAccess}
	 * labeled alternative in {@link DyslexiaParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide_arrayAccess(DyslexiaParser.LeftHandSide_arrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(DyslexiaParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(DyslexiaParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpression_conditionalOrExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression_conditionalOrExpression(DyslexiaParser.ConditionalExpression_conditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpression_conditionalOrExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression_conditionalOrExpression(DyslexiaParser.ConditionalExpression_conditionalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpression_operator}
	 * labeled alternative in {@link DyslexiaParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression_operator(DyslexiaParser.ConditionalExpression_operatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpression_operator}
	 * labeled alternative in {@link DyslexiaParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression_operator(DyslexiaParser.ConditionalExpression_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalOrExpression_conditionalAndExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression_conditionalAndExpression(DyslexiaParser.ConditionalOrExpression_conditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalOrExpression_conditionalAndExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression_conditionalAndExpression(DyslexiaParser.ConditionalOrExpression_conditionalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalOrExpression_conditionalOrExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression_conditionalOrExpression(DyslexiaParser.ConditionalOrExpression_conditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalOrExpression_conditionalOrExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression_conditionalOrExpression(DyslexiaParser.ConditionalOrExpression_conditionalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalAndExpression_inclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression_inclusiveOrExpression(DyslexiaParser.ConditionalAndExpression_inclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalAndExpression_inclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression_inclusiveOrExpression(DyslexiaParser.ConditionalAndExpression_inclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalAndExpression_conditionalAndExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression_conditionalAndExpression(DyslexiaParser.ConditionalAndExpression_conditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalAndExpression_conditionalAndExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression_conditionalAndExpression(DyslexiaParser.ConditionalAndExpression_conditionalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inclusiveOrExpression_inclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression_inclusiveOrExpression(DyslexiaParser.InclusiveOrExpression_inclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inclusiveOrExpression_inclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression_inclusiveOrExpression(DyslexiaParser.InclusiveOrExpression_inclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inclusiveOrExpression_exclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression_exclusiveOrExpression(DyslexiaParser.InclusiveOrExpression_exclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inclusiveOrExpression_exclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression_exclusiveOrExpression(DyslexiaParser.InclusiveOrExpression_exclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exclusiveOrExpression_exclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression_exclusiveOrExpression(DyslexiaParser.ExclusiveOrExpression_exclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exclusiveOrExpression_exclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression_exclusiveOrExpression(DyslexiaParser.ExclusiveOrExpression_exclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exclusiveOrExpression_andExpression}
	 * labeled alternative in {@link DyslexiaParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression_andExpression(DyslexiaParser.ExclusiveOrExpression_andExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exclusiveOrExpression_andExpression}
	 * labeled alternative in {@link DyslexiaParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression_andExpression(DyslexiaParser.ExclusiveOrExpression_andExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression_andExpression}
	 * labeled alternative in {@link DyslexiaParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression_andExpression(DyslexiaParser.AndExpression_andExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression_andExpression}
	 * labeled alternative in {@link DyslexiaParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression_andExpression(DyslexiaParser.AndExpression_andExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression_equalityExpression}
	 * labeled alternative in {@link DyslexiaParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression_equalityExpression(DyslexiaParser.AndExpression_equalityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression_equalityExpression}
	 * labeled alternative in {@link DyslexiaParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression_equalityExpression(DyslexiaParser.AndExpression_equalityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression_notEqual}
	 * labeled alternative in {@link DyslexiaParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression_notEqual(DyslexiaParser.EqualityExpression_notEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression_notEqual}
	 * labeled alternative in {@link DyslexiaParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression_notEqual(DyslexiaParser.EqualityExpression_notEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression_equal}
	 * labeled alternative in {@link DyslexiaParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression_equal(DyslexiaParser.EqualityExpression_equalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression_equal}
	 * labeled alternative in {@link DyslexiaParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression_equal(DyslexiaParser.EqualityExpression_equalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression_relationalExpression}
	 * labeled alternative in {@link DyslexiaParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression_relationalExpression(DyslexiaParser.EqualityExpression_relationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression_relationalExpression}
	 * labeled alternative in {@link DyslexiaParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression_relationalExpression(DyslexiaParser.EqualityExpression_relationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_lessThan}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_lessThan(DyslexiaParser.RelationalExpression_lessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_lessThan}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_lessThan(DyslexiaParser.RelationalExpression_lessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_shiftExpression}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_shiftExpression(DyslexiaParser.RelationalExpression_shiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_shiftExpression}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_shiftExpression(DyslexiaParser.RelationalExpression_shiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_greaterThan}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_greaterThan(DyslexiaParser.RelationalExpression_greaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_greaterThan}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_greaterThan(DyslexiaParser.RelationalExpression_greaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_instanceof}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_instanceof(DyslexiaParser.RelationalExpression_instanceofContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_instanceof}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_instanceof(DyslexiaParser.RelationalExpression_instanceofContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_greaterThanEqual}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_greaterThanEqual(DyslexiaParser.RelationalExpression_greaterThanEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_greaterThanEqual}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_greaterThanEqual(DyslexiaParser.RelationalExpression_greaterThanEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression_lessThanEqual}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression_lessThanEqual(DyslexiaParser.RelationalExpression_lessThanEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression_lessThanEqual}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression_lessThanEqual(DyslexiaParser.RelationalExpression_lessThanEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression_right2}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression_right2(DyslexiaParser.ShiftExpression_right2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression_right2}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression_right2(DyslexiaParser.ShiftExpression_right2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression_left}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression_left(DyslexiaParser.ShiftExpression_leftContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression_left}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression_left(DyslexiaParser.ShiftExpression_leftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression_right3}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression_right3(DyslexiaParser.ShiftExpression_right3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression_right3}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression_right3(DyslexiaParser.ShiftExpression_right3Context ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression_additiveExpression}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression_additiveExpression(DyslexiaParser.ShiftExpression_additiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression_additiveExpression}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression_additiveExpression(DyslexiaParser.ShiftExpression_additiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression_minus}
	 * labeled alternative in {@link DyslexiaParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression_minus(DyslexiaParser.AdditiveExpression_minusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression_minus}
	 * labeled alternative in {@link DyslexiaParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression_minus(DyslexiaParser.AdditiveExpression_minusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression_multiplicativeExpression}
	 * labeled alternative in {@link DyslexiaParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression_multiplicativeExpression(DyslexiaParser.AdditiveExpression_multiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression_multiplicativeExpression}
	 * labeled alternative in {@link DyslexiaParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression_multiplicativeExpression(DyslexiaParser.AdditiveExpression_multiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression_add}
	 * labeled alternative in {@link DyslexiaParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression_add(DyslexiaParser.AdditiveExpression_addContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression_add}
	 * labeled alternative in {@link DyslexiaParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression_add(DyslexiaParser.AdditiveExpression_addContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression_unaryExpression}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression_unaryExpression(DyslexiaParser.MultiplicativeExpression_unaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression_unaryExpression}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression_unaryExpression(DyslexiaParser.MultiplicativeExpression_unaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression_div}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression_div(DyslexiaParser.MultiplicativeExpression_divContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression_div}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression_div(DyslexiaParser.MultiplicativeExpression_divContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression_mult}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression_mult(DyslexiaParser.MultiplicativeExpression_multContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression_mult}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression_mult(DyslexiaParser.MultiplicativeExpression_multContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression_modulo}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression_modulo(DyslexiaParser.MultiplicativeExpression_moduloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression_modulo}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression_modulo(DyslexiaParser.MultiplicativeExpression_moduloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression_preIncrementExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression_preIncrementExpression(DyslexiaParser.UnaryExpression_preIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression_preIncrementExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression_preIncrementExpression(DyslexiaParser.UnaryExpression_preIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression_preDecrementExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression_preDecrementExpression(DyslexiaParser.UnaryExpression_preDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression_preDecrementExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression_preDecrementExpression(DyslexiaParser.UnaryExpression_preDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression_addUnaryExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression_addUnaryExpression(DyslexiaParser.UnaryExpression_addUnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression_addUnaryExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression_addUnaryExpression(DyslexiaParser.UnaryExpression_addUnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression_minusUnaryExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression_minusUnaryExpression(DyslexiaParser.UnaryExpression_minusUnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression_minusUnaryExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression_minusUnaryExpression(DyslexiaParser.UnaryExpression_minusUnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression_unaryExpressionNotPlusMinus}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression_unaryExpressionNotPlusMinus(DyslexiaParser.UnaryExpression_unaryExpressionNotPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression_unaryExpressionNotPlusMinus}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression_unaryExpressionNotPlusMinus(DyslexiaParser.UnaryExpression_unaryExpressionNotPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(DyslexiaParser.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(DyslexiaParser.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecrementExpression(DyslexiaParser.PreDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecrementExpression(DyslexiaParser.PreDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpressionNotPlusMinus_postfixExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionNotPlusMinus_postfixExpression(DyslexiaParser.UnaryExpressionNotPlusMinus_postfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpressionNotPlusMinus_postfixExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionNotPlusMinus_postfixExpression(DyslexiaParser.UnaryExpressionNotPlusMinus_postfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpressionNotPlusMinus_tilde}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionNotPlusMinus_tilde(DyslexiaParser.UnaryExpressionNotPlusMinus_tildeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpressionNotPlusMinus_tilde}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionNotPlusMinus_tilde(DyslexiaParser.UnaryExpressionNotPlusMinus_tildeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpressionNotPlusMinus_exclamationPoint}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionNotPlusMinus_exclamationPoint(DyslexiaParser.UnaryExpressionNotPlusMinus_exclamationPointContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpressionNotPlusMinus_exclamationPoint}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionNotPlusMinus_exclamationPoint(DyslexiaParser.UnaryExpressionNotPlusMinus_exclamationPointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpressionNotPlusMinus_castExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionNotPlusMinus_castExpression(DyslexiaParser.UnaryExpressionNotPlusMinus_castExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpressionNotPlusMinus_castExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionNotPlusMinus_castExpression(DyslexiaParser.UnaryExpressionNotPlusMinus_castExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(DyslexiaParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(DyslexiaParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(DyslexiaParser.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(DyslexiaParser.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression_lf_postfixExpression(DyslexiaParser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression_lf_postfixExpression(DyslexiaParser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression(DyslexiaParser.PostDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression(DyslexiaParser.PostDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression_lf_postfixExpression(DyslexiaParser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression_lf_postfixExpression(DyslexiaParser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DyslexiaParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(DyslexiaParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DyslexiaParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(DyslexiaParser.CastExpressionContext ctx);
}