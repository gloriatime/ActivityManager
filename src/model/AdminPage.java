package model;

import java.util.List;
import java.util.Set;

public class AdminPage {
	private int count_user;
	private int count_team;
	private int count_act;
	
	private List<Activity> act_begin_in_this_week;
	private List<Activity> act_have_warning;
	private List<Comment> new_comment_in_this_week;
	public int getCount_user() {
		return count_user;
	}
	public void setCount_user(int count_user) {
		this.count_user = count_user;
	}
	public int getCount_team() {
		return count_team;
	}
	public void setCount_team(int count_team) {
		this.count_team = count_team;
	}
	public int getCount_act() {
		return count_act;
	}
	public void setCount_act(int count_act) {
		this.count_act = count_act;
	}
	public List<Activity> getAct_begin_in_this_week() {
		return act_begin_in_this_week;
	}
	public void setAct_begin_in_this_week(List<Activity> act_begin_in_this_week) {
		this.act_begin_in_this_week = act_begin_in_this_week;
	}
	public List<Comment> getNew_comment_in_this_week() {
		return new_comment_in_this_week;
	}
	public void setNew_comment_in_this_week(List<Comment> new_comment_in_this_week) {
		this.new_comment_in_this_week = new_comment_in_this_week;
	}
	public List<Activity> getAct_have_warning() {
		return act_have_warning;
	}
	public void setAct_have_warning(List<Activity> act_have_warning) {
		this.act_have_warning = act_have_warning;
	}
}
