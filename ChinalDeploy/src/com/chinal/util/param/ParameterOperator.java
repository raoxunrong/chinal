package com.chinal.util.param;

import java.io.Serializable;

public class ParameterOperator implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static final String pEqure = "=";

//	public static final String pNoEqure = "<>";
	
	public static final String pNoEqure = "!=";

	public static final String pMore = ">";

	public static final String pLess = "<";

	public static final String pMoreOrEqure = ">=";

	public static final String pLessOrEqure = "<=";

	public static final String pLike = "like";

	public static final String pLikeLeft = "likeleft";

	public static final String pLikeRight = "likeright";
	
	public static final String pIs = "is";
	
	public static final String pIsNot = "is not";
	
	public static final String pIn = "in";
}
