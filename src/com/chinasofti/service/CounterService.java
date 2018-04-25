package com.chinasofti.service;

import com.chinasofti.dao.CounterDao;

public class CounterService {
	public Integer update(Integer counts) {
		boolean upadate = new CounterDao().upadate(counts);
		if (upadate) {
			return 1;
		}
		return 0;
	}

	public Integer select() {
		Integer select = new CounterDao().select();
		if (select == -1) {
			boolean insert = new CounterDao().insert();
			if (insert) {
				Integer select1 = new CounterDao().select();
				return 1;
			} else {
				return 0;
			}
		} else {
			return 1;
		}
	}
}
