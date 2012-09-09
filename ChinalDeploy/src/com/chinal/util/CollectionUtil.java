package com.chinal.util;

import java.util.Collection;

public class CollectionUtil {

	public static boolean isCollectionEmpty(@SuppressWarnings("rawtypes") Collection collection) {
		if (collection == null) {
			return true;
		}

		return collection.isEmpty();
	}
}
