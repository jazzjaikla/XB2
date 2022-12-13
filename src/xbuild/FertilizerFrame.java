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
import java.util.Date;
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
     * @param nodeName
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
        
        rdDaysAfterPlanting.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            rdDaysAfterPlantingStateChanged(evt);
        });
        
        setImage(imagePanel, "Fert2.jpg");
        
        EventQueue.invokeLater(() -> {            
            rdDaysAfterPlantingStateChanged(null);
            
            rdDaysAfterPlanting.setEnabled(!FileX.isFileOpenned || fertil.GetSize() == 0);
            rdReportedDates.setEnabled(!FileX.isFileOpenned || fertil.GetSize() == 0);
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
        lblLevel = new org.jdesktop.swingx.JXLabel();
        txtDescription = new xbuild.Components.XTextField();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        rdDaysAfterPlanting = new javax.swing.JRadioButton();
        rdReportedDates = new javax.swing.JRadioButton();
        bnAddLayer = new javax.swing.JButton();
        bnDeleteLayer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        imagePanel = new javax.swing.JLabel();
        lblLevel1 = new org.jdesktop.swingx.JXLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblLevel.setText("Level");
        lblLevel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescriptionFocusLost(evt);
            }
        });

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jXLabel2.setText("Management");

        buttonGroup1.add(rdDaysAfterPlanting);
        rdDaysAfterPlanting.setSelected(true);
        rdDaysAfterPlanting.setText("Days After Planting");

        buttonGroup1.add(rdReportedDates);
        rdReportedDates.setText("On Reported Dates");

        bnAddLayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Plus.png"))); // NOI18N
        bnAddLayer.setText("Add Application");
        bnAddLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAddLayerActionPerformed(evt);
            }
        });

        bnDeleteLayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Minus.png"))); // NOI18N
        bnDeleteLayer.setText("Delete Application");
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
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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

        imagePanel.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdDaysAfterPlanting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdReportedDates))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                        .addComponent(bnAddLayer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bnDeleteLayer)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(422, 422, 422))
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdDaysAfterPlanting)
                    .addComponent(rdReportedDates)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnDeleteLayer)
                    .addComponent(bnAddLayer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblLevel1.setText("Fertilizer");
        lblLevel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void rdDaysAfterPlantingStateChanged(javax.swing.event.ChangeEvent evt){
        if (rdDaysAfterPlanting.isSelected()) {
            TableColumn col = jXTable1.getColumn(0);
            col.setHeaderValue("Days After Planting");
            if (fertil.GetApps() != null) {
                fertil.GetApps().forEach(h -> {
                    h.FDATE = null;
                });
            }

            DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                Object valueAt = model.getValueAt(i, 0);
                try {
                    int val = Integer.parseInt(valueAt.toString());
                    model.setValueAt(0, i, 0);
                } catch (NumberFormatException ex) {
                    model.setValueAt(0, i, 0);
                }
            }
        } else {
            TableColumn col = jXTable1.getColumn(0);
            col.setHeaderValue("<html><p align='center'>Date<br>" + Variables.getDateFormatString() + "</p></html>");
            if (fertil.GetApps() != null) {
                fertil.GetApps().forEach(harvest -> {
                    harvest.FDAY = null;
                });
            }

            DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                Object valueAt = model.getValueAt(i, 0);
                if (valueAt != null) {
                    try {
                        long val = Date.parse(valueAt.toString());
                        if (val == 0) {
                            model.setValueAt(0, i, 0);
                        }
                    } catch (Exception ex) {
                        model.setValueAt(0, i, 0);
                    }
                }
            }
        }
    }
    
    private void bnAddLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddLayerActionPerformed
        FertilizerApplication fer;
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
                        Object[] row = SetRow(ferApp);
                        for (int n = 0; n < row.length; n++)
                            model.setValueAt(row[n], jXTable1.getSelectedRow(), n);
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
        DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
        for(int i = 0;i < fertil.GetSize();i++)
        {
            model.addRow(SetRow(fertil.GetApp(i)));
        }
    }

    private Object[] SetRow(FertilizerApplication ferApp) {

        Object day;
        Object FMCD;
        Object FACD;
        Object FDEP;
        Object FAMN;
        Object FAMP;
        Object FAMK;
        Object FAMC;
        Object FAMO;
        Object FOCD;
            
        try
        {
            day = Variables.getDateFormat().format(ferApp.FDATE);

            rdDaysAfterPlanting.setSelected(false);
            rdReportedDates.setSelected(true);
        }
        catch(Exception ex)
        {
            day = ferApp.FDAY;
            rdDaysAfterPlanting.setSelected(true);
            rdReportedDates.setSelected(false);
        }

        try
        {
            FMCD = FertilizerMaterialList.GetAt(ferApp.FMCD).Description;
        }
        catch(Exception ex) {
            FMCD = "";
        }
        try
        {
            FACD = FertilizerMethodList.GetAt(ferApp.FACD).Description;
        }
        catch(Exception ex) {
            FACD = "";
        }
        try
        {
            FDEP = ferApp.FDEP;
        }
        catch(Exception ex) {
            FDEP = "";
        }
        try
        {
            FAMN = ferApp.FAMN;
        }
        catch(Exception ex) {
            FAMN = "";
        }
        try
        {
            FAMP = ferApp.FAMP;
        }
        catch(Exception ex) {
            FAMP = "";
        }
        try
        {
            FAMK = ferApp.FAMK;
        }
        catch(Exception ex) {
            FAMK = "";
        }
        try
        {
            FAMC = ferApp.FAMC;
        }
        catch(Exception ex) {
            FAMC = "";
        }
        try
        {
            FAMO = ferApp.FAMO;
        }
        catch(Exception ex) {
            FAMO = "";
        }
        try
        {
            FOCD = ferApp.FOCD;
        }
        catch(Exception ex) {
            FOCD = "";
        }

        return new Object[] {day, FMCD, FACD, FDEP, FAMN, FAMP, FAMK, FAMC, FAMO, FOCD};
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAddLayer;
    private javax.swing.JButton bnDeleteLayer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXLabel lblLevel;
    private org.jdesktop.swingx.JXLabel lblLevel1;
    private javax.swing.JRadioButton rdDaysAfterPlanting;
    private javax.swing.JRadioButton rdReportedDates;
    private xbuild.Components.XTextField txtDescription;
    // End of variables declaration//GEN-END:variables
}
