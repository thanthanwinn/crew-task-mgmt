package org.mdt.crewtaskmanagement.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.mdt.crewtaskmanagement.exception.BalanceValidationException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
@Aspect
public class BalanceValidationAspect {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void apiMethods() {}

    @Before(value = "apiMethods() && args(.., result)", argNames = "result")
    public void validate(BindingResult result) {
        if(result.hasErrors()) {
            throw new BalanceValidationException(
                    result.getFieldErrors()
                            .stream()
                            .map(a -> a.getDefaultMessage())
                            .toList()
            );
        }
    }

}
