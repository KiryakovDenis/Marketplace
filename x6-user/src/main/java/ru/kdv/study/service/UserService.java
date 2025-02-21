package ru.kdv.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kdv.study.model.User;
import ru.kdv.study.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public User createUser(final User user) {
        return userRepository.insert(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public User update(final User user) {
        return userRepository.update(user);
    }

    @Transactional(readOnly = true)
    public User getById(final Long id) {
        return userRepository.getById(id);
    }

    @Transactional(readOnly = true)
    public Boolean userExist(final Long id) {
        return userRepository.userExist(id);
    }
}
