package com.studentform.service;

import com.studentform.model.AdminCell;
import com.studentform.repository.AdminCellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

/**
 * Custom Spring Security UserDetailsService implementation for AdminCell.
 * This service is responsible for loading user-specific data from the database.
 */
@Service
public class CustomAdminCellDetailsService implements UserDetailsService {

    @Autowired
    private AdminCellRepository adminCellRepository;

    /**
     * Locates the user based on the username (which is the email in this case).
     *
     * @param username The email of the admin cell.
     * @return a UserDetails object that Spring Security can use for authentication.
     * @throws UsernameNotFoundException if the user is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminCellRepository.findByEmail(username)
                .map(adminCell -> User.builder()
                        .username(adminCell.getEmail())
                        .password(adminCell.getPassword())
                        // Assign the 'ADMIN_CELL' role to this user.
                        .roles("ADMIN_CELL")
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException(
                        "AdminCell not found with email: " + username));
    }
}