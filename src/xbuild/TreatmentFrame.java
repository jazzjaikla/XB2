/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TreatmentFrame.java
 *
 * Created on Mar 18, 2010, 11:17:05 PM
 */

package xbuild;

import xbuild.Events.UpdateLevelEvent;
import DSSATModel.ExperimentType;
import Extensions.Utils;
import FileXModel.Treatment;
import FileXModel.FileX;
import FileXModel.ManagementList;
import FileXModel.ModelXBase;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import xbuild.Components.CultivarTableCellEditor;
import xbuild.Components.DescriptionTableCellEditor;
import xbuild.Components.IXInternalFrame;
import xbuild.Components.TreatmentTableCellEditor;
import xbuild.Events.LevelSelectionChangedEvent;

/**
 *
 * @author Jazzy
 */
public class TreatmentFrame extends IXInternalFrame  {

    private final ListSelectionListener listSelectionListener = (ListSelectionEvent e) -> {
        selectionChanged();
    };
    
    public JInternalFrame NewFrame(){
        return new TreatmentFrame();
    }
    
    /** Creates new form TreatmentFrame */
    public TreatmentFrame() {
        super();
        initComponents();
        
        LoadTreament();
        
        jXTable1.getSelectionModel().addListSelectionListener(listSelectionListener);
    }
    
    private void selectionChanged(){
        if(jXTable1.getSelectedRow() != level){
            level = jXTable1.getSelectedRow();
            listener.myAction((new LevelSelectionChangedEvent(this, "Treatments", level)));
        }
    }
    
    @Override
    public void updatePanelList(){
        LoadTreament();
    }
    
    @Override
    public void updatePanelName(String name){
        LoadTreament();
    }
    
    @Override
    public boolean isPrevButtonEnabled(){
        return true;
    }
    
    @Override
    public boolean isAddButtonEnabled(){
        return true;
    }
    @Override
    public boolean isDeleteButtonEnabled(){
        return jXTable1.getSelectedRow() >= 0;
    }
    
    
    @Override
    public void setSelection(int level){
        if(level >= 0){
            jXTable1.getSelectionModel().removeListSelectionListener(listSelectionListener);
            
            level = Math.min(level, jXTable1.getRowCount()) - 1;
            jXTable1.setRowSelectionInterval(level, level);
            
            jXTable1.getSelectionModel().addListSelectionListener(listSelectionListener);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        lblLevel1 = new org.jdesktop.swingx.JXLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setPreferredSize(new java.awt.Dimension(767, 677));

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Level", "<html>Rot.<br>Number</html>", "<html>Rot.<br>Option</html>", "<html>Crop<br>Comp.</html>", "Description", "Field", "<html>Initial<br>Conditions<html>", "<html>Soil<br>Anal.<html>", "Cultivar", "Planting", "Irrigation", "Fertililizers", "<html>Organic<br>Amendments</html>", "<html><p align='center'>Chem<br>App.</p></html>", "Tillage", "<html><p align='center'>Env.<br>Mod</p></html>", "Harvest", "<html><p align='center'>Sim.<br>Contr.</p></html>"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, false, false, true, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jXTable1);
        if (jXTable1.getColumnModel().getColumnCount() > 0) {
            jXTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jXTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
        }

        lblLevel1.setText("Treatments");
        lblLevel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 656, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXLabel lblLevel1;
    // End of variables declaration//GEN-END:variables


    private void LoadTreament() {
        EventQueue.invokeLater(() -> {
            int targetCol = 1;
            if (FileX.general.FileType == ExperimentType.Sequential) {
                targetCol = 4;
            }
                
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
            jXTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
            for (int i = 1; i < jXTable1.getColumnModel().getColumnCount(); i++) {
                
                if (i != targetCol) {
                    DefaultTableCellRenderer rightRenderer1 = new DefaultTableCellRenderer();
                    rightRenderer1.setHorizontalAlignment(SwingConstants.CENTER);
                    jXTable1.getColumnModel().getColumn(i).setCellRenderer(rightRenderer1);
                }
            }
            
            jXTable1.repaint();
        });
        
        DefaultTableModel tbModel = new DefaultTableModel();
        
        DefaultTableModel oldModel = (DefaultTableModel)jXTable1.getModel();
        
        for(int i = 0; i < oldModel.getColumnCount();i++){
            tbModel.addColumn(oldModel.getColumnName(i));
        }
        
        jXTable1.setModel(tbModel);
        for(ModelXBase model : FileX.treatments.GetAll())
        {
            Treatment treatment = (Treatment)model;
            Object row[] = new Object[18];
            row[0] = treatment.N;//i+1;
            try {
                row[1] = treatment.R;
            } catch (Exception e) {
                row[1] = "";
            }
            try {
                row[2] = treatment.O;
            } catch (Exception e) {
                row[2] = "";
            }
            try {
                row[3] = treatment.C;
            } catch (Exception e) {
                row[3] = "";
            }
            
            try {
                row[4] = treatment.TNAME;
            } catch (Exception e) {
                row[4] = "";
            }
            try {
                row[5] = treatment.FL;
            } catch (Exception e) {
                row[5] = "";
            }
            try {
                row[6] = treatment.IC;
            } catch (Exception e) {
                row[6] = "";
            }
            try {
                row[7] = treatment.SA;
            } catch (Exception e) {
                row[7] = "";
            }
            try {
                row[8] = treatment.CU;
            } catch (Exception e) {
                row[8] = "";
            }
            try {
                row[9] = treatment.MP;
            } catch (Exception e) {
                row[0] = "";
            }
            try {
                row[10] = treatment.MI;
            } catch (Exception e) {
                row[10] = "";
            }
            try {
                row[11] = treatment.MF;
            } catch (Exception e) {
                row[11] = "";
            }
            try {
                row[12] = treatment.MR;
            } catch (Exception e) {
                row[12] = "";
            }
            try {
                row[13] = treatment.MC;
            } catch (Exception e) {
                row[13] = "";
            }
            try {
                row[14] = treatment.MT;
            } catch (Exception e) {
                row[14] = "";
            }
            try {
                row[15] = treatment.ME;
            } catch (Exception e) {
                row[15] = "";
            }
            try {
                row[16] = treatment.MH;
            } catch (Exception e) {
                row[16] = "";
            }
            try {
                row[17] = treatment.SM;
            } catch (Exception e) {
                row[17] = "";
            }
            tbModel.addRow(row);
        }
        
        tbModel.addTableModelListener((TableModelEvent e) -> {
            int row = e.getFirstRow();
            DefaultTableModel tbModel1 = (DefaultTableModel) jXTable1.getModel();
            
            ((Treatment)FileX.treatments.GetAtIndex(row)).TNAME = (String) tbModel1.getValueAt(row, 4);
            ((Treatment)FileX.treatments.GetAtIndex(row)).N = Utils.ParseInteger(tbModel1.getValueAt(row, 0));
            
            if (FileX.general.FileType == ExperimentType.Sequential) {
                ((Treatment)FileX.treatments.GetAtIndex(row)).R = (String) tbModel1.getValueAt(row, 1);
                ((Treatment)FileX.treatments.GetAtIndex(row)).O = (String) tbModel1.getValueAt(row, 2);
                ((Treatment)FileX.treatments.GetAtIndex(row)).C = (String) tbModel1.getValueAt(row, 3);
            }
            
            ((Treatment)FileX.treatments.GetAtIndex(row)).FL = Utils.ParseInteger(tbModel1.getValueAt(row, 5));
            ((Treatment)FileX.treatments.GetAtIndex(row)).IC = Utils.ParseInteger(tbModel1.getValueAt(row, 6));
            ((Treatment)FileX.treatments.GetAtIndex(row)).SA = Utils.ParseInteger(tbModel1.getValueAt(row, 7));
            ((Treatment)FileX.treatments.GetAtIndex(row)).CU = Utils.ParseInteger(tbModel1.getValueAt(row, 8));
            ((Treatment)FileX.treatments.GetAtIndex(row)).MP = Utils.ParseInteger(tbModel1.getValueAt(row, 9));
            ((Treatment)FileX.treatments.GetAtIndex(row)).MI = Utils.ParseInteger(tbModel1.getValueAt(row, 10));
            ((Treatment)FileX.treatments.GetAtIndex(row)).MF = Utils.ParseInteger(tbModel1.getValueAt(row, 11));
            ((Treatment)FileX.treatments.GetAtIndex(row)).MR = Utils.ParseInteger(tbModel1.getValueAt(row, 12));
            ((Treatment)FileX.treatments.GetAtIndex(row)).MC = Utils.ParseInteger(tbModel1.getValueAt(row, 13));
            ((Treatment)FileX.treatments.GetAtIndex(row)).MT = Utils.ParseInteger(tbModel1.getValueAt(row, 14));
            ((Treatment)FileX.treatments.GetAtIndex(row)).ME = Utils.ParseInteger(tbModel1.getValueAt(row, 15));
            ((Treatment)FileX.treatments.GetAtIndex(row)).MH = Utils.ParseInteger(tbModel1.getValueAt(row, 16));
            ((Treatment)FileX.treatments.GetAtIndex(row)).SM = Utils.ParseInteger(tbModel1.getValueAt(row, 17));
            
            listener.myAction(new UpdateLevelEvent(this, "Treatments", "Level " + ((Treatment)FileX.treatments.GetAtIndex(row)).N + ": " + FileX.treatments.GetAtIndex(row).GetName(), row));
        });
        
        jXTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jXTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
        
        jXTable1.getColumnModel().getColumn(4).setCellEditor(new DescriptionTableCellEditor());
        
        jXTable1.getColumnModel().getColumn(5).setCellEditor(new TreatmentTableCellEditor(FileX.fieldList));
        jXTable1.getColumnModel().getColumn(6).setCellEditor(new TreatmentTableCellEditor(FileX.initialList));
        jXTable1.getColumnModel().getColumn(7).setCellEditor(new TreatmentTableCellEditor(FileX.soilAnalysis));
        jXTable1.getColumnModel().getColumn(8).setCellEditor(new CultivarTableCellEditor());
        jXTable1.getColumnModel().getColumn(9).setCellEditor(new TreatmentTableCellEditor(FileX.plantings));
        jXTable1.getColumnModel().getColumn(10).setCellEditor(new TreatmentTableCellEditor(FileX.irrigations));
        jXTable1.getColumnModel().getColumn(11).setCellEditor(new TreatmentTableCellEditor(FileX.fertilizerList));
        jXTable1.getColumnModel().getColumn(12).setCellEditor(new TreatmentTableCellEditor(FileX.organicList));
        jXTable1.getColumnModel().getColumn(13).setCellEditor(new TreatmentTableCellEditor(FileX.chemicalList));
        jXTable1.getColumnModel().getColumn(14).setCellEditor(new TreatmentTableCellEditor(FileX.tillageList));
        jXTable1.getColumnModel().getColumn(15).setCellEditor(new TreatmentTableCellEditor(FileX.environmentals));
        jXTable1.getColumnModel().getColumn(16).setCellEditor(new TreatmentTableCellEditor(FileX.harvestList));
        jXTable1.getColumnModel().getColumn(17).setCellEditor(new TreatmentTableCellEditor(FileX.simulationList));
       
        
        if(ExperimentType.Sequential != FileX.general.FileType){
            jXTable1.removeColumn(jXTable1.getColumnModel().getColumn(3));
            jXTable1.removeColumn(jXTable1.getColumnModel().getColumn(2));
            jXTable1.removeColumn(jXTable1.getColumnModel().getColumn(1));
        }
    }

    @Override
    public ManagementList getManagementList() {
        return FileX.treatments;
    }
    
    @Override
    public String getManagementName() {
        return "Treatments";
    }
    
    @Override
    public ModelXBase getModel(){
        try{
            int index = jXTable1.getSelectedRow();
            Treatment treatment = (Treatment) FileX.treatments.GetAtIndex(index);
            
            return treatment;
        }
        catch(Exception ex){
            return null;
        }
    }
    
    @Override
    public int getLevel(){
        return jXTable1.getSelectedRow() + 1;
    }
    
    @Override
    public String getTitle(){
        try{
            int index = jXTable1.getSelectedRow();
            Treatment treatment = (Treatment) FileX.treatments.GetAtIndex(index);
            
            return "Level " + treatment.GetLevel() + ": " + treatment.GetName();
        }
        catch(Exception ex){
            return "";
        }
    }
    
    @Override
    public String getDescription(){
        try{
            int index = jXTable1.getSelectedRow();
            Treatment treatment = (Treatment) FileX.treatments.GetAtIndex(index);
            
            return treatment.GetName();
        }
        catch(Exception ex){
            return "";
        }
    }

    @Override
    public String getParentName() {
        return getManagementName();
    }

    @Override
    public ModelXBase newModel() {
        return null;
    }
}
