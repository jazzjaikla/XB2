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

import xbuild.Events.RemoveLevelEvent;
import xbuild.Events.AddLevelEvent;
import xbuild.Events.UpdateLevelEvent;
import DSSATModel.ExperimentType;
import Extensions.Utils;
import FileXModel.Treatment;
import FileXModel.FileX;
import FileXDialog.CultivarDialog;
import FileXDialog.FieldDialog;
import FileXModel.ModelXBase;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import xbuild.Components.IXInternalFrame;
import xbuild.Events.MenuDirection;
import xbuild.Events.NewFrameEvent;

/**
 *
 * @author Jazzy
 */
public class TreatmentFrame extends IXInternalFrame  {

    public JInternalFrame NewFrame(){
        return new TreatmentFrame();
    }
    
    /** Creates new form TreatmentFrame */
    public TreatmentFrame() {
        initComponents();
        
        LoadTreament();        
    }
    
    @Override
    public void updatePanelList(){
        LoadTreament();
    }
    
    @Override
    public void updatePanelName(String name){
        LoadTreament();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bnAddLayer = new javax.swing.JButton();
        bnDeleteLayer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        lblLevel1 = new org.jdesktop.swingx.JXLabel();
        bnPrevious = new javax.swing.JButton();
        bnNext = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setPreferredSize(new java.awt.Dimension(767, 677));

        bnAddLayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Plus.png"))); // NOI18N
        bnAddLayer.setText("Add");
        bnAddLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAddLayerActionPerformed(evt);
            }
        });

        bnDeleteLayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Minus.png"))); // NOI18N
        bnDeleteLayer.setText("Delete");
        bnDeleteLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDeleteLayerActionPerformed(evt);
            }
        });

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Level", "<html>Rot.<br>Number</html>", "<html>Rot.<br>Option</html>", "<html>Crop<br>Comp.</html>", "Description", "Cultivar", "Field", "<html>Soil<br>Anal.<html>", "<html>Init.<br>Cond.<html>", "Plant", "Irrigat.", "Fertil.", "Resid.", "<html><p align='center'>Chem<br>App.</p></html>", "Tillage", "<html><p align='center'>Env.<br>Mod</p></html>", "Harvest", "<html><p align='center'>Sim.<br>Contr.</p></html>"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jXTable1);
        if (jXTable1.getColumnModel().getColumnCount() > 0) {
            jXTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jXTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
        }

        lblLevel1.setText("Treatments");
        lblLevel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        bnPrevious.setText("PREVIOUS");
        bnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnPreviousActionPerformed(evt);
            }
        });

        bnNext.setText("NEXT");
        bnNext.setEnabled(false);
        bnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 463, Short.MAX_VALUE)
                        .addComponent(bnAddLayer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bnDeleteLayer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bnNext)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnPrevious)
                    .addComponent(bnNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnAddLayer)
                    .addComponent(lblLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnDeleteLayer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked
        int row = jXTable1.getSelectedRow();

        if(row > jXTable1.getRowCount());
        int col = jXTable1.getSelectedColumn();

        //jXTable1.getColumnModel().getColumn(col).getWidth();
        Point p = jXTable1.getLocationOnScreen();
        
        for(int i = 0;i < col;i++)
            p.x += jXTable1.getColumnModel().getColumn(i).getWidth();

        p.y += (row + 1) * jXTable1.getRowHeight();

        int addCol = FileX.general.FileType == ExperimentType.Sequential ? 3 : 0;

        if(col == 2 + addCol) ShowCultivar(col, row, p);
        else if(col == 3 + addCol) ShowField(col, row, p);
        else if(col == 4 + addCol) ShowSoilAnalysis(col, row, p);
        else if(col == 5 + addCol) ShowInitial(col, row, p);
        else if(col == 6 + addCol) ShowPlant(col, row, p);
        else if(col == 7 + addCol) ShowIrrigation(col, row, p);
        else if(col == 8 + addCol) ShowFertilizer(col, row, p);
        else if(col == 9 + addCol) ShowOrganic(col, row, p);
        else if(col == 10 + addCol) ShowChemical(col, row, p);
        else if(col == 11 + addCol) ShowTillage(col, row, p);
        else if(col == 12 + addCol) ShowEnvironment(col, row, p);
        else if(col == 13 + addCol) ShowHarvest(col, row, p);
        else if(col == 14 + addCol) ShowSimulation(col, row, p);
    }//GEN-LAST:event_jXTable1MouseClicked

    private void bnAddLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddLayerActionPerformed
        int row = jXTable1.getSelectedRow();
        Treatment treatment = null;
        if (row >= 0) {
            try {
                treatment = ((Treatment)FileX.treaments.GetAtIndex(row)).Clone();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TreatmentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(FileX.general.FileType != ExperimentType.Sequential){
                treatment.SetLevel(FileX.treaments.GetSize() + 1);
            }
            else{
                Integer r = Utils.ParseInteger(((Treatment)FileX.treaments.GetAtIndex(FileX.treaments.GetSize() - 1)).R) + 1;
                treatment.R = r.toString();
            }
        }
        else {
            treatment = new Treatment();
            treatment.SetLevel(FileX.general.FileType == ExperimentType.Sequential ? 1 : FileX.treaments.GetSize() + 1);
        }
        
        if(FileX.treaments.GetSize() == 0){
            treatment.CU = FileX.cultivars.GetAtIndex(0).GetLevel();
            treatment.FL = FileX.fieldList.GetAtIndex(0).GetLevel();
            treatment.MP = FileX.plantings.GetAtIndex(0).GetLevel();
            treatment.SM = FileX.simulationList.GetAtIndex(0).GetLevel();
        }
        

        FileX.treaments.AddNew(treatment);
        LoadTreament();
        
        l.myAction(new AddLevelEvent(this, "Treatments", "Level " + treatment.GetLevel() + ": " + treatment.GetName()));
    }//GEN-LAST:event_bnAddLayerActionPerformed

    private void bnDeleteLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteLayerActionPerformed
        int row = jXTable1.getSelectedRow();
        String name = FileX.treaments.GetAtIndex(row).GetName();
        FileX.treaments.RemoveAt(row);
        LoadTreament();
        
        l.myAction(new RemoveLevelEvent(this, "Treatments", "Level " + (row+1) + ": " + name));
    }//GEN-LAST:event_bnDeleteLayerActionPerformed

    private void bnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnPreviousActionPerformed
        EventQueue.invokeLater(() -> {
            l.myAction(new NewFrameEvent(this, "Treatments", MenuDirection.PREVIOUS));
        });
    }//GEN-LAST:event_bnPreviousActionPerformed

    private void bnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnNextActionPerformed
        EventQueue.invokeLater(() -> {
            l.myAction(new NewFrameEvent(this, "Treatments", MenuDirection.NEXT));
        });
    }//GEN-LAST:event_bnNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAddLayer;
    private javax.swing.JButton bnDeleteLayer;
    private javax.swing.JButton bnNext;
    private javax.swing.JButton bnPrevious;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXLabel lblLevel1;
    // End of variables declaration//GEN-END:variables

    private void ShowCultivar(final int col, final int row, Point p) {
        final CultivarDialog dialog = new CultivarDialog();
        dialog.setLocation(p);
        dialog.show();
        
        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).CU = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowField(final int col, final int row, Point p) {
        final FieldDialog dialog = new FieldDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).FL = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowSoilAnalysis(final int col, final int row, Point p) {
        final FileXDialog.SoilAnalysisDialog dialog = new FileXDialog.SoilAnalysisDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).SA = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowInitial(final int col, final int row, Point p) {
        final FileXDialog.InitialDialog dialog = new FileXDialog.InitialDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).IC = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowSimulation(final int col, final int row, Point p) {
        final FileXDialog.SimulationDialog dialog = new FileXDialog.SimulationDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).SM = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowHarvest(final int col, final int row, Point p) {
        final FileXDialog.HarvestlDialog dialog = new FileXDialog.HarvestlDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).MH = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowEnvironment(final int col, final int row, Point p) {
        final FileXDialog.EnvironmentalDialog dialog = new FileXDialog.EnvironmentalDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).ME = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowTillage(final int col, final int row, Point p) {
        final FileXDialog.TillageDialog dialog = new FileXDialog.TillageDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).MT = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowChemical(final int col, final int row, Point p) {
        final FileXDialog.ChemicalDialog dialog = new FileXDialog.ChemicalDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).MC = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowOrganic(final int col, final int row, Point p) {
        final FileXDialog.OrganicDialog dialog = new FileXDialog.OrganicDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).MR = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowFertilizer(final int col, final int row, Point p) {
        final FileXDialog.FertilizerDialog dialog = new FileXDialog.FertilizerDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).MF = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowIrrigation(final int col, final int row, Point p) {
        final FileXDialog.IrrigationDialog dialog = new FileXDialog.IrrigationDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).MI = level;
                    LoadTreament();
                }
            }
        });
    }

    private void ShowPlant(final int col, final int row, Point p) {
        final FileXDialog.PlantingDialog dialog = new FileXDialog.PlantingDialog();
        dialog.setLocation(p);
        dialog.show();

        dialog.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Integer level = dialog.GetLevel();
                if(level != null){
                    ((Treatment)FileX.treaments.GetAtIndex(row)).MP = level;
                    LoadTreament();
                }
            }
        });
    }

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
        });
        
        DefaultTableModel tbModel = new DefaultTableModel();
        
        DefaultTableModel oldModel = (DefaultTableModel)jXTable1.getModel();
        
        for(int i = 0; i < oldModel.getColumnCount();i++){
            tbModel.addColumn(oldModel.getColumnName(i));
        }
        
        jXTable1.setModel(tbModel);
        for(ModelXBase model : FileX.treaments.GetAll())
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
                row[5] = treatment.CU;
            } catch (Exception e) {
                row[5] = "";
            }
            try {
                row[6] = treatment.FL;
            } catch (Exception e) {
                row[6] = "";
            }
            try {
                row[7] = treatment.SA;
            } catch (Exception e) {
                row[7] = "";
            }
            try {
                row[8] = treatment.IC;
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
            
            ((Treatment)FileX.treaments.GetAtIndex(row)).TNAME = (String) tbModel1.getValueAt(row, 4);
            ((Treatment)FileX.treaments.GetAtIndex(row)).N = Utils.ParseInteger(tbModel1.getValueAt(row, 0));
            if (FileX.general.FileType == ExperimentType.Sequential) {
                ((Treatment)FileX.treaments.GetAtIndex(row)).R = (String) tbModel1.getValueAt(row, 1);
                ((Treatment)FileX.treaments.GetAtIndex(row)).O = (String) tbModel1.getValueAt(row, 2);
                ((Treatment)FileX.treaments.GetAtIndex(row)).C = (String) tbModel1.getValueAt(row, 3);
            }
            
            l.myAction(new UpdateLevelEvent(this, "Treatments", "Level " + (row+1) + ": " + FileX.treaments.GetAtIndex(row).GetName(), row));
        });
        
        jXTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jXTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
        
        if(ExperimentType.Sequential != FileX.general.FileType){
            jXTable1.removeColumn(jXTable1.getColumnModel().getColumn(3));
            jXTable1.removeColumn(jXTable1.getColumnModel().getColumn(2));
            jXTable1.removeColumn(jXTable1.getColumnModel().getColumn(1));
        }
    }
}
