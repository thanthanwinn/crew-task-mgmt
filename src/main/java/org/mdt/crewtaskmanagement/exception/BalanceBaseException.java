package org.mdt.crewtaskmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BalanceBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private List<String> messages;


}
