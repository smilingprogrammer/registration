package com.example.registration.appuser;

import java.util.Optional;

public interface AppUserRepository {

    Optional<AppUser> findByEmail(String email);
}
