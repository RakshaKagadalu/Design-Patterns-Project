package edu.neu.csye7374.Factory;

public interface BikeFactoryAPI<T> {
	public  T getObject(BuilderAPI<T> builder);
}
