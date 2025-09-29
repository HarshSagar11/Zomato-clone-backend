package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.entities.Wallet;
import com.zomatoclone.Zomato.Clone.repositories.WalletRepository;
import com.zomatoclone.Zomato.Clone.services.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Value("${wallet.initial.balance}")
    private double initialBalance;

    @Override
    public Wallet createWallet() {

        Wallet wallet = new Wallet();
        wallet.setBalance(initialBalance);
        return(walletRepository.save(wallet));
    }
}
