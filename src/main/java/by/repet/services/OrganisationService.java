package by.repet.services;//Created by vladr on 30.04.2017.

import by.repet.domain.Organisation;

import java.util.Collection;

public interface OrganisationService {
    Organisation getOrganisation(Long organisationId);
    Collection<Organisation> getAll();
    Organisation add(Organisation organisation);
    void remove(Long organisationId);
}
