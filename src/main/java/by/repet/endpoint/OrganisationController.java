package by.repet.endpoint;//Created by vladr on 30.04.2017.

import by.repet.domain.Organisation;
import by.repet.services.OrganisationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("api/organisation")
public class OrganisationController {

    private final OrganisationService organisationService;

    @GetMapping
    public Collection<Organisation> getOrganisations() {
        return organisationService.getAll();
    }

    @PostMapping
    public Organisation saveOrganisation(Organisation organisation) {
        return organisationService.add(organisation);
    }

}
