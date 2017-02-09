/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.TypCviceniaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.TypCvicenia;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.CvicenieManager;

/**
 *
 * @author ntb
 */
public class TypCviceniaComboBoxModel extends DefaultComboBoxModel<TypCvicenia> {

    private final CvicenieManager cvicenieManager = ObjectFactory.INSTANCE.getCvicenieManager();
    private final TypCviceniaDao dao = ObjectFactory.INSTANCE.getTypCviceniaDao();
    private List<TypCvicenia> typyCvicenia;

    public TypCviceniaComboBoxModel() {
        aktualizovat();
    }

   

    public void aktualizovat() {
        removeAllElements();
        typyCvicenia = dao.dajVsetkyTypy();
        for (TypCvicenia typCvicenia : typyCvicenia) {
            addElement(typCvicenia);
        }
    }

}
