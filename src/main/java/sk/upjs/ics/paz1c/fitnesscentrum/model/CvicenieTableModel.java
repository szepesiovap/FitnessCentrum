package sk.upjs.ics.paz1c.fitnesscentrum.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;
import sk.upjs.ics.paz1c.fitnesscentrum.dao.TypCviceniaDao;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Cvicenie;
import sk.upjs.ics.paz1c.fitnesscentrum.entity.Spinning;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.CvicenieManager;
import sk.upjs.ics.paz1c.fitnesscentrum.manager.SpinningManager;

public class CvicenieTableModel extends AbstractTableModel {

    private final CvicenieManager cvicenieManager = ObjectFactory.INSTANCE.getCvicenieManager();

    private static final String[] NAZVY_STLPCOV = {"Dátum", "Inštruktor", "Počet voľných miest", "Počet miest", "Typ" };
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    private List<Cvicenie> listCviceni = cvicenieManager.dajVsetkyCvicenia();
    private TypCviceniaDao dao = ObjectFactory.INSTANCE.getTypCviceniaDao();

    public CvicenieTableModel() {
        aktualizovat();
    }

    @Override
    public int getRowCount() {
        return listCviceni.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cvicenie cvicenie = listCviceni.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cvicenie.getDatum().toLocalDate() + " " + cvicenie.getDatum().toLocalTime();
            case 1:
                return cvicenie.getInstruktor();
            case 2:
                return cvicenie.getVolne();
            case 3:
                return cvicenie.getKapacita();
            case 4:
                return cvicenie.getId();
            case 5: 
                return (dao.dajTypPodlaId(cvicenie.getId())).getNazov();
            default:
                return "???";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    public void aktualizovat() {
        listCviceni = cvicenieManager.dajVsetkyCvicenia();
        fireTableDataChanged();
    }
}
