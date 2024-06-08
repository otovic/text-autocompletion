package config;

public abstract class UseCaseWithParams<Type, Params> extends UseCase {
    public abstract Type call(Params params);
}
