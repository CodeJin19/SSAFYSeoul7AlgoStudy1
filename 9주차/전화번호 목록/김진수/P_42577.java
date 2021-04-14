package com.ssafy.algoStudy_09;

import java.util.ArrayList;

public class P_42577 {
	public boolean check(ArrayList<String> inputList) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> tmp;
		int len = inputList.size();

		if (len <= 1)
			return true;

		for (int i = 0; i < 10; i++) {
			tmp = new ArrayList<String>();
			list.add(tmp);
		}

		for (int i = 0; i < len; i++) {
			if(inputList.get(i).length() == 0)
				return false;
			
			switch (inputList.get(i).charAt(0)) {
            case '0':
				list.get(0).add(inputList.get(i).substring(1));
				break;
			case '1':
				list.get(1).add(inputList.get(i).substring(1));
				break;
			case '2':
				list.get(2).add(inputList.get(i).substring(1));
				break;
			case '3':
				list.get(3).add(inputList.get(i).substring(1));
				break;
			case '4':
				list.get(4).add(inputList.get(i).substring(1));
				break;
			case '5':
				list.get(5).add(inputList.get(i).substring(1));
				break;
			case '6':
				list.get(6).add(inputList.get(i).substring(1));
				break;
			case '7':
				list.get(7).add(inputList.get(i).substring(1));
				break;
			case '8':
				list.get(8).add(inputList.get(i).substring(1));
				break;
			case '9':
				list.get(9).add(inputList.get(i).substring(1));
				break;
			}
		}

		for (int i = 0; i < 10; i++)
			if (!check(list.get(i)))
				return false;
		
		return true;
	}

	public boolean solution(String[] phone_book) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> tmp;

		for (int i = 0; i < 10; i++) {
			tmp = new ArrayList<String>();
			list.add(tmp);
		}

		for (int i = 0; i < phone_book.length; i++) {
			switch (phone_book[i].charAt(0)) {
            case '0':
				list.get(0).add(phone_book[i].substring(1));
				break;
			case '1':
				list.get(1).add(phone_book[i].substring(1));
				break;
			case '2':
				list.get(2).add(phone_book[i].substring(1));
				break;
			case '3':
				list.get(3).add(phone_book[i].substring(1));
				break;
			case '4':
				list.get(4).add(phone_book[i].substring(1));
				break;
			case '5':
				list.get(5).add(phone_book[i].substring(1));
				break;
			case '6':
				list.get(6).add(phone_book[i].substring(1));
				break;
			case '7':
				list.get(7).add(phone_book[i].substring(1));
				break;
			case '8':
				list.get(8).add(phone_book[i].substring(1));
				break;
			case '9':
				list.get(9).add(phone_book[i].substring(1));
				break;
			}
		}

		for (int i = 0; i < 10; i++)
			if (!check(list.get(i)))
				return false;

		return true;
	}
}
