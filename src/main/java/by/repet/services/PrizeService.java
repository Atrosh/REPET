package by.repet.services;//Created by vladr on 22.05.2017.

import by.repet.domain.Prize;

import java.util.List;

public interface PrizeService {
    List<Prize> getAll();

    List<Prize> getByGameId(Long gameId);

    List<Prize> getByUserId(Long userId);

    Prize save(Prize prize);

    void remove(Long prizeId);
}
