package com.hostfully.framework.usecase;

public abstract class BaseUseCase<
    IN extends BaseUseCase.InputValues, OUT extends BaseUseCase.OutputValues> {
  public abstract OUT execute(IN input);

  public interface InputValues {}

  public interface OutputValues {}
}
