// Generated from D:\Documents\Graduate Studies\CSC617M\MP\minimum-requirements\csc617m_dyslexia\dyslexia\src\dyslexia\grammar\Dyslexia.g4 by ANTLR 4.5.3
package dyslexia.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DyslexiaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DyslexiaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(DyslexiaParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatingPointLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointLiteral(DyslexiaParser.FloatingPointLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(DyslexiaParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharacterLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterLiteral(DyslexiaParser.CharacterLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(DyslexiaParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link DyslexiaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(DyslexiaParser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(DyslexiaParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericType_integralType}
	 * labeled alternative in {@link DyslexiaParser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericType_integralType(DyslexiaParser.NumericType_integralTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numericType_floatingPointType}
	 * labeled alternative in {@link DyslexiaParser#numericType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericType_floatingPointType(DyslexiaParser.NumericType_floatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#integralType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegralType(DyslexiaParser.IntegralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#floatingPointType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointType(DyslexiaParser.FloatingPointTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#referenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceType(DyslexiaParser.ReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(DyslexiaParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(DyslexiaParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType_lf_classOrInterfaceType(DyslexiaParser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType_lfno_classOrInterfaceType(DyslexiaParser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(DyslexiaParser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType_lf_classOrInterfaceType(DyslexiaParser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType_lfno_classOrInterfaceType(DyslexiaParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVariable(DyslexiaParser.TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(DyslexiaParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#dims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDims(DyslexiaParser.DimsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(DyslexiaParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifier(DyslexiaParser.TypeParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBound(DyslexiaParser.TypeBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#additionalBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionalBound(DyslexiaParser.AdditionalBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(DyslexiaParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentList(DyslexiaParser.TypeArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgument(DyslexiaParser.TypeArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#wildcard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcard(DyslexiaParser.WildcardContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#wildcardBounds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWildcardBounds(DyslexiaParser.WildcardBoundsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(DyslexiaParser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(DyslexiaParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#packageOrTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageOrTypeName(DyslexiaParser.PackageOrTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionName_Identifier}
	 * labeled alternative in {@link DyslexiaParser#expressionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionName_Identifier(DyslexiaParser.ExpressionName_IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionName_ambiguousName}
	 * labeled alternative in {@link DyslexiaParser#expressionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionName_ambiguousName(DyslexiaParser.ExpressionName_ambiguousNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(DyslexiaParser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#ambiguousName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmbiguousName(DyslexiaParser.AmbiguousNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(DyslexiaParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(DyslexiaParser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#packageModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageModifier(DyslexiaParser.PackageModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(DyslexiaParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTypeImportDeclaration(DyslexiaParser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeImportOnDemandDeclaration(DyslexiaParser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStaticImportDeclaration(DyslexiaParser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticImportOnDemandDeclaration(DyslexiaParser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(DyslexiaParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(DyslexiaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalClassDeclaration(DyslexiaParser.NormalClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(DyslexiaParser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(DyslexiaParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterList(DyslexiaParser.TypeParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#superclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperclass(DyslexiaParser.SuperclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#superinterfaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperinterfaces(DyslexiaParser.SuperinterfacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceTypeList(DyslexiaParser.InterfaceTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(DyslexiaParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(DyslexiaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classMemberDeclaration_fieldDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration_fieldDeclaration(DyslexiaParser.ClassMemberDeclaration_fieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classMemberDeclaration_methodDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration_methodDeclaration(DyslexiaParser.ClassMemberDeclaration_methodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classMemberDeclaration_classDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration_classDeclaration(DyslexiaParser.ClassMemberDeclaration_classDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classMemberDeclaration_interfaceDeclaration}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration_interfaceDeclaration(DyslexiaParser.ClassMemberDeclaration_interfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classMemberDeclaration_semicolon}
	 * labeled alternative in {@link DyslexiaParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration_semicolon(DyslexiaParser.ClassMemberDeclaration_semicolonContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(DyslexiaParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldModifier_annotation}
	 * labeled alternative in {@link DyslexiaParser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier_annotation(DyslexiaParser.FieldModifier_annotationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldModifier_public}
	 * labeled alternative in {@link DyslexiaParser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier_public(DyslexiaParser.FieldModifier_publicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldModifier_protected}
	 * labeled alternative in {@link DyslexiaParser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier_protected(DyslexiaParser.FieldModifier_protectedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldModifier_private}
	 * labeled alternative in {@link DyslexiaParser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier_private(DyslexiaParser.FieldModifier_privateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldModifier_static}
	 * labeled alternative in {@link DyslexiaParser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier_static(DyslexiaParser.FieldModifier_staticContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldModifier_final}
	 * labeled alternative in {@link DyslexiaParser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier_final(DyslexiaParser.FieldModifier_finalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldModifier_transient}
	 * labeled alternative in {@link DyslexiaParser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier_transient(DyslexiaParser.FieldModifier_transientContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldModifier_volatile}
	 * labeled alternative in {@link DyslexiaParser#fieldModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldModifier_volatile(DyslexiaParser.FieldModifier_volatileContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorList(DyslexiaParser.VariableDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(DyslexiaParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaratorId(DyslexiaParser.VariableDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableInitializer_expression}
	 * labeled alternative in {@link DyslexiaParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer_expression(DyslexiaParser.VariableInitializer_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableInitializer_arrayInitializer}
	 * labeled alternative in {@link DyslexiaParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer_arrayInitializer(DyslexiaParser.VariableInitializer_arrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unannType_unannPrimitiveType}
	 * labeled alternative in {@link DyslexiaParser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannType_unannPrimitiveType(DyslexiaParser.UnannType_unannPrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unannType_unannReferenceType}
	 * labeled alternative in {@link DyslexiaParser#unannType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannType_unannReferenceType(DyslexiaParser.UnannType_unannReferenceTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unannPrimitiveType_numericType}
	 * labeled alternative in {@link DyslexiaParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannPrimitiveType_numericType(DyslexiaParser.UnannPrimitiveType_numericTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unannPrimitiveType_boolean}
	 * labeled alternative in {@link DyslexiaParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannPrimitiveType_boolean(DyslexiaParser.UnannPrimitiveType_booleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unannReferenceType_ClassOrInterfaceType}
	 * labeled alternative in {@link DyslexiaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannReferenceType_ClassOrInterfaceType(DyslexiaParser.UnannReferenceType_ClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unannReferenceType_TypeVariable}
	 * labeled alternative in {@link DyslexiaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannReferenceType_TypeVariable(DyslexiaParser.UnannReferenceType_TypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unannReferenceType_ArrayType}
	 * labeled alternative in {@link DyslexiaParser#unannReferenceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannReferenceType_ArrayType(DyslexiaParser.UnannReferenceType_ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassOrInterfaceType(DyslexiaParser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#unannClassType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType(DyslexiaParser.UnannClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType_lf_unannClassOrInterfaceType(DyslexiaParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannClassType_lfno_unannClassOrInterfaceType(DyslexiaParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#unannInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType(DyslexiaParser.UnannInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType_lf_unannClassOrInterfaceType(DyslexiaParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannInterfaceType_lfno_unannClassOrInterfaceType(DyslexiaParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#unannTypeVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannTypeVariable(DyslexiaParser.UnannTypeVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#unannArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnannArrayType(DyslexiaParser.UnannArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(DyslexiaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#methodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodModifier(DyslexiaParser.MethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(DyslexiaParser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code result_unannType}
	 * labeled alternative in {@link DyslexiaParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult_unannType(DyslexiaParser.Result_unannTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code result_void}
	 * labeled alternative in {@link DyslexiaParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult_void(DyslexiaParser.Result_voidContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#methodDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarator(DyslexiaParser.MethodDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formalParameterList_receiverParameter}
	 * labeled alternative in {@link DyslexiaParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList_receiverParameter(DyslexiaParser.FormalParameterList_receiverParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formalParameterList_formalParameters}
	 * labeled alternative in {@link DyslexiaParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList_formalParameters(DyslexiaParser.FormalParameterList_formalParametersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code formalParameterList_lastFormalParameter}
	 * labeled alternative in {@link DyslexiaParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList_lastFormalParameter(DyslexiaParser.FormalParameterList_lastFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(DyslexiaParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(DyslexiaParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableModifier_annotation}
	 * labeled alternative in {@link DyslexiaParser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier_annotation(DyslexiaParser.VariableModifier_annotationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableModifier_final}
	 * labeled alternative in {@link DyslexiaParser#variableModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableModifier_final(DyslexiaParser.VariableModifier_finalContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFormalParameter(DyslexiaParser.LastFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#receiverParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverParameter(DyslexiaParser.ReceiverParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#throws_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrows_(DyslexiaParser.Throws_Context ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionTypeList(DyslexiaParser.ExceptionTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#exceptionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionType(DyslexiaParser.ExceptionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(DyslexiaParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#instanceInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceInitializer(DyslexiaParser.InstanceInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#staticInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticInitializer(DyslexiaParser.StaticInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(DyslexiaParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#constructorModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorModifier(DyslexiaParser.ConstructorModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#constructorDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclarator(DyslexiaParser.ConstructorDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#simpleTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeName(DyslexiaParser.SimpleTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(DyslexiaParser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitConstructorInvocation(DyslexiaParser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#enumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDeclaration(DyslexiaParser.EnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#enumBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBody(DyslexiaParser.EnumBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#enumConstantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantList(DyslexiaParser.EnumConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#enumConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstant(DyslexiaParser.EnumConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#enumConstantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantModifier(DyslexiaParser.EnumConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumBodyDeclarations(DyslexiaParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(DyslexiaParser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalInterfaceDeclaration(DyslexiaParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#interfaceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceModifier(DyslexiaParser.InterfaceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#extendsInterfaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtendsInterfaces(DyslexiaParser.ExtendsInterfacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#interfaceBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBody(DyslexiaParser.InterfaceBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMemberDeclaration(DyslexiaParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#constantDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDeclaration(DyslexiaParser.ConstantDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#constantModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantModifier(DyslexiaParser.ConstantModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodDeclaration(DyslexiaParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceMethodModifier(DyslexiaParser.InterfaceMethodModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeDeclaration(DyslexiaParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeBody(DyslexiaParser.AnnotationTypeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeMemberDeclaration(DyslexiaParser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementDeclaration(DyslexiaParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationTypeElementModifier(DyslexiaParser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(DyslexiaParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(DyslexiaParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#normalAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalAnnotation(DyslexiaParser.NormalAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#elementValuePairList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePairList(DyslexiaParser.ElementValuePairListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#elementValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValuePair(DyslexiaParser.ElementValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#elementValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValue(DyslexiaParser.ElementValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueArrayInitializer(DyslexiaParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#elementValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementValueList(DyslexiaParser.ElementValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#markerAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMarkerAnnotation(DyslexiaParser.MarkerAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleElementAnnotation(DyslexiaParser.SingleElementAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(DyslexiaParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#variableInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializerList(DyslexiaParser.VariableInitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(DyslexiaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#blockStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatements(DyslexiaParser.BlockStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(DyslexiaParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(DyslexiaParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(DyslexiaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DyslexiaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#statementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementNoShortIf(DyslexiaParser.StatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_block}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_block(DyslexiaParser.StatementWithoutTrailingSubstatement_blockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_emptyStatement}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_emptyStatement(DyslexiaParser.StatementWithoutTrailingSubstatement_emptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_expressionStatement}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_expressionStatement(DyslexiaParser.StatementWithoutTrailingSubstatement_expressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_assertStatement}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_assertStatement(DyslexiaParser.StatementWithoutTrailingSubstatement_assertStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_switchStatement}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_switchStatement(DyslexiaParser.StatementWithoutTrailingSubstatement_switchStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_doStatement}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_doStatement(DyslexiaParser.StatementWithoutTrailingSubstatement_doStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_breakStatement}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_breakStatement(DyslexiaParser.StatementWithoutTrailingSubstatement_breakStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_continueStatement}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_continueStatement(DyslexiaParser.StatementWithoutTrailingSubstatement_continueStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_returnStatement}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_returnStatement(DyslexiaParser.StatementWithoutTrailingSubstatement_returnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_synchronizedStatement}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_synchronizedStatement(DyslexiaParser.StatementWithoutTrailingSubstatement_synchronizedStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_throwStatement}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_throwStatement(DyslexiaParser.StatementWithoutTrailingSubstatement_throwStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementWithoutTrailingSubstatement_tryStatement}
	 * labeled alternative in {@link DyslexiaParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWithoutTrailingSubstatement_tryStatement(DyslexiaParser.StatementWithoutTrailingSubstatement_tryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(DyslexiaParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(DyslexiaParser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatementNoShortIf(DyslexiaParser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(DyslexiaParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(DyslexiaParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#ifThenStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenStatement(DyslexiaParser.IfThenStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatement(DyslexiaParser.IfThenElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElseStatementNoShortIf(DyslexiaParser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(DyslexiaParser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(DyslexiaParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#switchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlock(DyslexiaParser.SwitchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(DyslexiaParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#switchLabels}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabels(DyslexiaParser.SwitchLabelsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabel(DyslexiaParser.SwitchLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#enumConstantName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumConstantName(DyslexiaParser.EnumConstantNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(DyslexiaParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatementNoShortIf(DyslexiaParser.WhileStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(DyslexiaParser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(DyslexiaParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatementNoShortIf(DyslexiaParser.ForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#basicForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatement(DyslexiaParser.BasicForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicForStatementNoShortIf(DyslexiaParser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(DyslexiaParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(DyslexiaParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#statementExpressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpressionList(DyslexiaParser.StatementExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#enhancedForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatement(DyslexiaParser.EnhancedForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnhancedForStatementNoShortIf(DyslexiaParser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(DyslexiaParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(DyslexiaParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(DyslexiaParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(DyslexiaParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#synchronizedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynchronizedStatement(DyslexiaParser.SynchronizedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(DyslexiaParser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#catches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatches(DyslexiaParser.CatchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(DyslexiaParser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#catchFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchFormalParameter(DyslexiaParser.CatchFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#catchType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchType(DyslexiaParser.CatchTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#finally_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinally_(DyslexiaParser.Finally_Context ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryWithResourcesStatement(DyslexiaParser.TryWithResourcesStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#resourceSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceSpecification(DyslexiaParser.ResourceSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#resourceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceList(DyslexiaParser.ResourceListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#resource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResource(DyslexiaParser.ResourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(DyslexiaParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray(DyslexiaParser.PrimaryNoNewArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_arrayAccess(DyslexiaParser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_literal}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess_literal(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_type}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess_type(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_void}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess_void(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_voidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_this}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess_this(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_thisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_typethis}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess_typethis(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_typethisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_expression}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess_expression(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_classInstance}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess_classInstance(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_classInstanceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_fieldAccess}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess_fieldAccess(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_fieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_methodInvocation}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess_methodInvocation(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_methodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_arrayAccess_methodReference}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_arrayAccess_methodReference(DyslexiaParser.PrimaryNoNewArray_lfno_arrayAccess_methodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary(DyslexiaParser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(DyslexiaParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(DyslexiaParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_literal}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_literal(DyslexiaParser.PrimaryNoNewArray_lfno_primary_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_type}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_type(DyslexiaParser.PrimaryNoNewArray_lfno_primary_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_unnann}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_unnann(DyslexiaParser.PrimaryNoNewArray_lfno_primary_unnannContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_void}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_void(DyslexiaParser.PrimaryNoNewArray_lfno_primary_voidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_this}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_this(DyslexiaParser.PrimaryNoNewArray_lfno_primary_thisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_typethis}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_typethis(DyslexiaParser.PrimaryNoNewArray_lfno_primary_typethisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_expression}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_expression(DyslexiaParser.PrimaryNoNewArray_lfno_primary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_class}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_class(DyslexiaParser.PrimaryNoNewArray_lfno_primary_classContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_field}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_field(DyslexiaParser.PrimaryNoNewArray_lfno_primary_fieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_array}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_array(DyslexiaParser.PrimaryNoNewArray_lfno_primary_arrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_methodInvocation}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_methodInvocation(DyslexiaParser.PrimaryNoNewArray_lfno_primary_methodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryNoNewArray_lfno_primary_methodReference}
	 * labeled alternative in {@link DyslexiaParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_methodReference(DyslexiaParser.PrimaryNoNewArray_lfno_primary_methodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(DyslexiaParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(DyslexiaParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression(DyslexiaParser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression_lf_primary(DyslexiaParser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceCreationExpression_lfno_primary(DyslexiaParser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArgumentsOrDiamond(DyslexiaParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#fieldAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess(DyslexiaParser.FieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess_lf_primary(DyslexiaParser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAccess_lfno_primary(DyslexiaParser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(DyslexiaParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess_lf_primary(DyslexiaParser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess_lfno_primary(DyslexiaParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation_methodName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_methodName(DyslexiaParser.MethodInvocation_methodNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation_typeName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_typeName(DyslexiaParser.MethodInvocation_typeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation_expressionName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_expressionName(DyslexiaParser.MethodInvocation_expressionNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation_primary}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_primary(DyslexiaParser.MethodInvocation_primaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation_super}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_super(DyslexiaParser.MethodInvocation_superContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation_typeNameSuper}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_typeNameSuper(DyslexiaParser.MethodInvocation_typeNameSuperContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lf_primary(DyslexiaParser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation_lfno_primary_methodName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lfno_primary_methodName(DyslexiaParser.MethodInvocation_lfno_primary_methodNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation_lfno_primary_typeName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lfno_primary_typeName(DyslexiaParser.MethodInvocation_lfno_primary_typeNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation_lfno_primary_expressionName}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lfno_primary_expressionName(DyslexiaParser.MethodInvocation_lfno_primary_expressionNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation_lfno_primary_super}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lfno_primary_super(DyslexiaParser.MethodInvocation_lfno_primary_superContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodInvocation_lfno_primary_typeNameSuper}
	 * labeled alternative in {@link DyslexiaParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation_lfno_primary_typeNameSuper(DyslexiaParser.MethodInvocation_lfno_primary_typeNameSuperContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(DyslexiaParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#methodReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference(DyslexiaParser.MethodReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference_lf_primary(DyslexiaParser.MethodReference_lf_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodReference_lfno_primary(DyslexiaParser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpression(DyslexiaParser.ArrayCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#dimExprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExprs(DyslexiaParser.DimExprsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#dimExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimExpr(DyslexiaParser.DimExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(DyslexiaParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expression_lambdaExpression}
	 * labeled alternative in {@link DyslexiaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_lambdaExpression(DyslexiaParser.Expression_lambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expression_assignmentExpression}
	 * labeled alternative in {@link DyslexiaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_assignmentExpression(DyslexiaParser.Expression_assignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(DyslexiaParser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(DyslexiaParser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInferredFormalParameterList(DyslexiaParser.InferredFormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#lambdaBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaBody(DyslexiaParser.LambdaBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentExpression_conditionalExpression}
	 * labeled alternative in {@link DyslexiaParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression_conditionalExpression(DyslexiaParser.AssignmentExpression_conditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpression_assignment}
	 * labeled alternative in {@link DyslexiaParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression_assignment(DyslexiaParser.ConditionalExpression_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(DyslexiaParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code leftHandSide_expressionName}
	 * labeled alternative in {@link DyslexiaParser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide_expressionName(DyslexiaParser.LeftHandSide_expressionNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code leftHandSide_fieldAccess}
	 * labeled alternative in {@link DyslexiaParser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide_fieldAccess(DyslexiaParser.LeftHandSide_fieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code leftHandSide_arrayAccess}
	 * labeled alternative in {@link DyslexiaParser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide_arrayAccess(DyslexiaParser.LeftHandSide_arrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(DyslexiaParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpression_conditionalOrExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression_conditionalOrExpression(DyslexiaParser.ConditionalExpression_conditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpression_operator}
	 * labeled alternative in {@link DyslexiaParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression_operator(DyslexiaParser.ConditionalExpression_operatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalOrExpression_conditionalAndExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression_conditionalAndExpression(DyslexiaParser.ConditionalOrExpression_conditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalOrExpression_conditionalOrExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalOrExpression_conditionalOrExpression(DyslexiaParser.ConditionalOrExpression_conditionalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalAndExpression_inclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression_inclusiveOrExpression(DyslexiaParser.ConditionalAndExpression_inclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalAndExpression_conditionalAndExpression}
	 * labeled alternative in {@link DyslexiaParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalAndExpression_conditionalAndExpression(DyslexiaParser.ConditionalAndExpression_conditionalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inclusiveOrExpression_inclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression_inclusiveOrExpression(DyslexiaParser.InclusiveOrExpression_inclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inclusiveOrExpression_exclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression_exclusiveOrExpression(DyslexiaParser.InclusiveOrExpression_exclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exclusiveOrExpression_exclusiveOrExpression}
	 * labeled alternative in {@link DyslexiaParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression_exclusiveOrExpression(DyslexiaParser.ExclusiveOrExpression_exclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exclusiveOrExpression_andExpression}
	 * labeled alternative in {@link DyslexiaParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression_andExpression(DyslexiaParser.ExclusiveOrExpression_andExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression_andExpression}
	 * labeled alternative in {@link DyslexiaParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression_andExpression(DyslexiaParser.AndExpression_andExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression_equalityExpression}
	 * labeled alternative in {@link DyslexiaParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression_equalityExpression(DyslexiaParser.AndExpression_equalityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression_notEqual}
	 * labeled alternative in {@link DyslexiaParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression_notEqual(DyslexiaParser.EqualityExpression_notEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression_equal}
	 * labeled alternative in {@link DyslexiaParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression_equal(DyslexiaParser.EqualityExpression_equalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression_relationalExpression}
	 * labeled alternative in {@link DyslexiaParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression_relationalExpression(DyslexiaParser.EqualityExpression_relationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_lessThan}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_lessThan(DyslexiaParser.RelationalExpression_lessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_shiftExpression}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_shiftExpression(DyslexiaParser.RelationalExpression_shiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_greaterThan}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_greaterThan(DyslexiaParser.RelationalExpression_greaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_instanceof}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_instanceof(DyslexiaParser.RelationalExpression_instanceofContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_greaterThanEqual}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_greaterThanEqual(DyslexiaParser.RelationalExpression_greaterThanEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression_lessThanEqual}
	 * labeled alternative in {@link DyslexiaParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression_lessThanEqual(DyslexiaParser.RelationalExpression_lessThanEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression_right2}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression_right2(DyslexiaParser.ShiftExpression_right2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression_left}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression_left(DyslexiaParser.ShiftExpression_leftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression_right3}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression_right3(DyslexiaParser.ShiftExpression_right3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression_additiveExpression}
	 * labeled alternative in {@link DyslexiaParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression_additiveExpression(DyslexiaParser.ShiftExpression_additiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression_minus}
	 * labeled alternative in {@link DyslexiaParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression_minus(DyslexiaParser.AdditiveExpression_minusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression_multiplicativeExpression}
	 * labeled alternative in {@link DyslexiaParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression_multiplicativeExpression(DyslexiaParser.AdditiveExpression_multiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression_add}
	 * labeled alternative in {@link DyslexiaParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression_add(DyslexiaParser.AdditiveExpression_addContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_unaryExpression}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_unaryExpression(DyslexiaParser.MultiplicativeExpression_unaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_div}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_div(DyslexiaParser.MultiplicativeExpression_divContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_mult}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_mult(DyslexiaParser.MultiplicativeExpression_multContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression_modulo}
	 * labeled alternative in {@link DyslexiaParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression_modulo(DyslexiaParser.MultiplicativeExpression_moduloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression_preIncrementExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression_preIncrementExpression(DyslexiaParser.UnaryExpression_preIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression_preDecrementExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression_preDecrementExpression(DyslexiaParser.UnaryExpression_preDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression_addUnaryExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression_addUnaryExpression(DyslexiaParser.UnaryExpression_addUnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression_minusUnaryExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression_minusUnaryExpression(DyslexiaParser.UnaryExpression_minusUnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression_unaryExpressionNotPlusMinus}
	 * labeled alternative in {@link DyslexiaParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression_unaryExpressionNotPlusMinus(DyslexiaParser.UnaryExpression_unaryExpressionNotPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(DyslexiaParser.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecrementExpression(DyslexiaParser.PreDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpressionNotPlusMinus_postfixExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus_postfixExpression(DyslexiaParser.UnaryExpressionNotPlusMinus_postfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpressionNotPlusMinus_tilde}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus_tilde(DyslexiaParser.UnaryExpressionNotPlusMinus_tildeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpressionNotPlusMinus_exclamationPoint}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus_exclamationPoint(DyslexiaParser.UnaryExpressionNotPlusMinus_exclamationPointContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpressionNotPlusMinus_castExpression}
	 * labeled alternative in {@link DyslexiaParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpressionNotPlusMinus_castExpression(DyslexiaParser.UnaryExpressionNotPlusMinus_castExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(DyslexiaParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(DyslexiaParser.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression_lf_postfixExpression(DyslexiaParser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression(DyslexiaParser.PostDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecrementExpression_lf_postfixExpression(DyslexiaParser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DyslexiaParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(DyslexiaParser.CastExpressionContext ctx);
}