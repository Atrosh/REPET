package by.repet.services.Impl;//Created by vladr on 23.05.2017.

import by.repet.domain.Prize;
import by.repet.repositories.PrizeRepository;
import by.repet.services.PrizeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PrizeServiceImpl implements PrizeService {

    private final PrizeRepository prizeRepository;

    @Override
    public List<Prize> getAll() {
        return prizeRepository.findAll();
    }

    @Override
    public List<Prize> getByGameId(Long gameId) {
        return prizeRepository.findAllByTicketGameId(gameId);
    }

    @Override
    public List<Prize> getByUserId(Long userId) {
        return prizeRepository.findAllByTicketOwnerId(userId);
    }

    @Override
    public Prize save(Prize prize) {
        return prizeRepository.save(prize);
    }

    @Override
    public void remove(Long prizeId) {
        prizeRepository.delete(prizeId);
    }
}
