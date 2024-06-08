package config;

public abstract class UseCaseNoParams<Type> extends UseCase {
    public abstract Type call();
}
