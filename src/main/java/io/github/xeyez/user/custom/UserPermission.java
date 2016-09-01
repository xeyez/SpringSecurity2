package io.github.xeyez.user.custom;

public class UserPermission {
	private Long id;
	private String name;

	public UserPermission(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserPermission [id=" + id + ", name=" + name + "]";
	}
}
