package com.web.custom.annot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Redir_Controlr {
	/**
     * The name of the controller
     */
    String name() default "";
    
    /**
     * The URL patterns of the controller
     */
    String[] value() default {};

    /**
     * The URL patterns of the controller
     */
    String[] ctrlrUrlPatterns() default {};

    /**
     * The display name of the controller
     */
    String displayName() default "";
}
