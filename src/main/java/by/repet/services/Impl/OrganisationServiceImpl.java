package by.repet.services.Impl;//Created by vladr on 30.04.2017.

import by.repet.domain.Organisation;
import by.repet.repositories.OrganisationRepository;
import by.repet.services.OrganisationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

    private final OrganisationRepository organisationRepository;

    @Override
    public Organisation getOrganisation(Long organisationId) {
        return organisationRepository.findOne(organisationId);
    }

    @Override
    public Collection<Organisation> getAll() {
        return organisationRepository.findAll();
    }

    @Override
    public Organisation add(Organisation organisation) {
        return organisationRepository.save(organisation);
    }

    @Override
    public void remove(Long organisationId) {
        organisationRepository.delete(organisationId);
    }

}
