package com.dfostic.web;

import com.dfostic.interfaces.PlayerModifier;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author dfostic1
 */
@Aspect
public class AspectPlayerModifier {

    @DeclareParents(value = "com.dfostic.beans.IPlayer+", defaultImpl = PlayerModifierImpl.class)
    public static AspectPlayerModifier playerModifier;
}
