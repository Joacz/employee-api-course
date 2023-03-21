package net.joagz.employees_api.dto;

import java.util.List;

import net.joagz.employees_api.models.Authorities;

public record UserDto(String username, String email, List<Authorities> authorities) {

}
