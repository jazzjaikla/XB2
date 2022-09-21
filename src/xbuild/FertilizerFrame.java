package xbuild;

import DSSATModel.FertilizerMaterialList;
import DSSATModel.FertilizerMethodList;
import Extensions.Variables;
import FileXModel.Fertilizer;
import FileXModel.FertilizerApplication;
import FileXModel.FileX;
import FileXModel.IModelXBase;
import java.awt.EventQueue;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import xbuild.Components.IXInternalFrame;
import xbuild.Events.UpdateLevelEvent;

/**
 *
 * @author Jazzy
 */
public class FertilizerFrame extends IXInternalFrame {

    protected Fertilizer fertil;
    private int selectedRowIndex = -1;
    private Integer level;
    /**
     * Creates new form FertilizerFrame
     */
    public FertilizerFrame(String nodeName) {
        initComponents();
        
        level = 0;
        for(IModelXBase fer : FileX.fertilizerList.GetAll()){
            level++;
            if(getLevel(nodeName) == level){
                this.fertil = (Fertilizer)fer;
                break;
            }
        }

        LoadFertilizer();
        
        lblLevel.setText("Level " + level.toString());
        txtDescription.Init(fertil, "FERNAME", fertil.FERNAME);
        
        EventQueue.invokeLater(() -> {            
            setImage(imagePanel, setup.GetDSSATPath() + "\\Tools\\XBuild\\Fert2.jpg");
        });
    }
    
    /**
     *
     * @param name
     */
    @Override
    public void updatePanelName(String name){
        FocusListener[] listens = txtDescription.getListeners(FocusListener.class);
        for(FocusListener li : listens)
            txtDescription.removeFocusListener(li);
        
        level = 0;
        for (IModelXBase f : FileX.fertilizerList.GetAll()) {
            level++;
            if(getLevel(name) == level){                
                lblLevel.setText("Level " + level.toString());
                txtDescription.setText(getDescription(name));
                break;
            }
        }   
        
        for(FocusListener li : listens)
            this.addFocusListener(li);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtYear = new javax.swing.JTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        rdDaysAfterPlanting = new javax.swing.JRadioButton();
        rdReportedDates = new javax.swing.JRadioButton();
        bnAddLayer = new javax.swing.JButton();
        bnDeleteLayer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        lblLevel = new org.jdesktop.swingx.JXLabel();
        txtDescription = new xbuild.Components.XTextField();
        imagePanel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jXLabel1.setText("Year");

        txtYear.setEditable(false);

        jXLabel2.setText("Management");

        buttonGroup1.add(rdDaysAfterPlanting);
        rdDaysAfterPlanting.setSelected(true);
        rdDaysAfterPlanting.setText("Days After Planting");
        rdDaysAfterPlanting.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdDaysAfterPlantingItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rdReportedDates);
        rdReportedDates.setText("On Reported Dates");

        bnAddLayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Plus.png"))); // NOI18N
        bnAddLayer.setText("Add Layer");
        bnAddLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAddLayerActionPerformed(evt);
            }
        });

        bnDeleteLayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Minus.png"))); // NOI18N
        bnDeleteLayer.setText("Delete Layer");
        bnDeleteLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDeleteLayerActionPerformed(evt);
            }
        });

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "<html><p align='center'>Fertilizer<br>Material</p></html>", "<html><p align='center'>Fertilizer<br>Applications</p></html>", "<html><p align='center'>Depth<br>cm</p></html>", "<html><p align='center'>N<br>kg ha-1</p></html>", "<html><p align='center'>P<br>kg ha-1</p></html>", "<html><p align='center'>K<br>kg ha-1</p></html>", "<html><p align='center'>Ca<br>kg ha-1</p></html>", "<html><p align='center'>Other<br>elements<br>kg ha-1</p></html>", "<html> <table width='100%'><tr><td align='center'> Other<br>Element<br>Code</td></tr></table> </html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

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

        lblLevel.setText("Level");
        lblLevel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescriptionFocusLost(evt);
            }
        });

        imagePanel.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(bnAddLayer)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bnDeleteLayer))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdDaysAfterPlanting)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdReportedDates))
                                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdDaysAfterPlanting)
                            .addComponent(rdReportedDates)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bnDeleteLayer)
                            .addComponent(bnAddLayer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdDaysAfterPlantingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdDaysAfterPlantingItemStateChanged
        if(rdDaysAfterPlanting.isSelected())
        {
            TableColumn col = jXTable1.getColumn(0);
            col.setHeaderValue("Day");
        }
        else
        {
            TableColumn col = jXTable1.getColumn(0);
            col.setHeaderValue("Date");
        }
        DefaultTableModel model = (DefaultTableModel)jXTable1.getModel();
        for(int i = 0;i < model.getRowCount();i++)
        model.setValueAt("", i, 0);
    }//GEN-LAST:event_rdDaysAfterPlantingItemStateChanged

    private void bnAddLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddLayerActionPerformed
        FertilizerApplication fer = null;
        if (selectedRowIndex >= 0 && selectedRowIndex < fertil.GetSize()) {
            FertilizerApplication tmp = fertil.GetApp(selectedRowIndex);
            fer = tmp.Clone();
        } else {
            fer = new FertilizerApplication();
        }

        final FertilizerDialog ferDialog = new FertilizerDialog(null, true, rdDaysAfterPlanting.isSelected(), fer);
        ferDialog.show();

        ferDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                FertilizerApplication ferApp = ferDialog.GetData();
                if(ferApp != null){
                    DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
                    while(model.getRowCount() > 0)
                        model.removeRow(0);
                    
                    fertil.AddApp(ferApp);
                    
                    for (int i = 0; i < fertil.GetSize(); i++) {                        
                        model.addRow(SetRow(fertil.GetApp(i)));
                    }
                }
                ferDialog.SetNull();
            }
        });
    }//GEN-LAST:event_bnAddLayerActionPerformed

    private void bnDeleteLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteLayerActionPerformed
        int nRow = jXTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
        model.removeRow(nRow);

        fertil.RemoveAt(nRow);
    }//GEN-LAST:event_bnDeleteLayerActionPerformed

    private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked
        if(evt.getClickCount() == 2)
        {
            final FertilizerDialog ferDialog = new FertilizerDialog(null, true, rdDaysAfterPlanting.isSelected(), fertil.GetApp(jXTable1.getSelectedRow()));
            ferDialog.show();

            ferDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    FertilizerApplication ferApp = ferDialog.GetData();
                    if(ferApp != null){
                        DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
                        Vector vector = SetRow(ferApp);
                        for(int n = 0;n < vector.size();n++)
                        model.setValueAt(vector.get(n), jXTable1.getSelectedRow(), n);
                    }
                    ferDialog.SetNull();
                }
            });
        }
        else{
            int nRow = jXTable1.getSelectedRow();

            if(nRow != selectedRowIndex){
                selectedRowIndex = nRow;
            }
            else{
                selectedRowIndex = -1;
                jXTable1.clearSelection();
            }
        }
    }//GEN-LAST:event_jXTable1MouseClicked

    private void txtDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescriptionFocusLost
        if(txtDescription.getText() == null ? fertil.FERNAME != null : !txtDescription.getText().equals(fertil.FERNAME)){
            l.myAction(new UpdateLevelEvent(this, "Fertilizer", "Level " + level + ": " + txtDescription.getText(), level - 1));
        }
    }//GEN-LAST:event_txtDescriptionFocusLost

    private void LoadFertilizer() {
        txtYear.setText(FileX.general.Year);

        DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
        for(int i = 0;i < fertil.GetSize();i++)
        {
            model.addRow(SetRow(fertil.GetApp(i)));
        }
    }

    private Vector SetRow(FertilizerApplication ferApp) {

        Vector vector = new Vector();
        try
        {
            vector.addElement(Variables.getDateFormat().format(ferApp.FDATE));

            rdDaysAfterPlanting.setSelected(false);
            rdReportedDates.setSelected(true);
        }
        catch(Exception ex)
        {
            vector.add(ferApp.FDAY);
            rdDaysAfterPlanting.setSelected(true);
            rdReportedDates.setSelected(false);
        }

        try
        {
            vector.add(FertilizerMaterialList.GetAt(ferApp.FMCD).Description);
        }
        catch(Exception ex) {
            vector.add("");
        }
        try
        {
            vector.add(FertilizerMethodList.GetAt(ferApp.FACD).Description);
        }
        catch(Exception ex) {
            vector.add("");
        }
        try
        {
            vector.add(ferApp.FDEP);
        }
        catch(Exception ex) {
            vector.add("");
        }
        try
        {
            vector.add(ferApp.FAMN);
        }
        catch(Exception ex) {
            vector.add("");
        }
        try
        {
            vector.add(ferApp.FAMP);
        }
        catch(Exception ex) {
            vector.add("");
        }
        try
        {
            vector.add(ferApp.FAMK);
        }
        catch(Exception ex) {
            vector.add("");
        }
        try
        {
            vector.add(ferApp.FAMC);
        }
        catch(Exception ex) {
            vector.add("");
        }
        try
        {
            vector.add(ferApp.FAMO);
        }
        catch(Exception ex) {
            vector.add("");
        }
        try
        {
            vector.add(ferApp.FOCD);
        }
        catch(Exception ex) {
            vector.add("");
        }

        return vector;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAddLayer;
    private javax.swing.JButton bnDeleteLayer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXLabel lblLevel;
    private javax.swing.JRadioButton rdDaysAfterPlanting;
    private javax.swing.JRadioButton rdReportedDates;
    private xbuild.Components.XTextField txtDescription;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
