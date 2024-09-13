package com.jsf.hib;

import java.util.List;

public interface MenuDAO {

	List<Menu> showMenuByRestaurant(int rid);
}
