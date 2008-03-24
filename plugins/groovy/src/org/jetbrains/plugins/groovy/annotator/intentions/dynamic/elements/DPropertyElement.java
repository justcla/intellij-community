package org.jetbrains.plugins.groovy.annotator.intentions.dynamic.elements;

import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiVariable;
import org.jetbrains.plugins.groovy.lang.psi.impl.synthetic.GrDynamicImplicitProperty;

/**
 * User: Dmitry.Krasilschikov
 * Date: 20.12.2007
 */
public class DPropertyElement extends DItemElement {
  private PsiVariable myPsi;

  //Do not use directly! Persistence component uses default constructor for deserializable
  public DPropertyElement() {
    super(null, null);
  }

  public DPropertyElement(String name, String type) {
    super(name, type);
  }

  public void clearCache() {
    myPsi = null;
  }

  public PsiVariable getPsi(PsiManager manager, String containingClassName) {
    if (myPsi != null) return myPsi;
    myPsi = new GrDynamicImplicitProperty(manager, getName(), getType(), containingClassName);
    return myPsi;
  }
}
