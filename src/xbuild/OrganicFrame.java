package xbuild;

import DSSATModel.FertilizerMethodList;
import DSSATModel.ResiduesList;
import Extensions.Variables;
import FileXModel.FileX;
import FileXModel.ModelXBase;
import FileXModel.Organic;
import FileXModel.OrganicApplication;
import java.awt.EventQueue;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import xbuild.Components.IXInternalFrame;
import xbuild.Events.UpdateLevelEvent;

/**
 *
 * @author Jazzy
 */
public class OrganicFrame extends IXInternalFrame {

    protected Organic organic;
    private int selectedRowIndex = -1;
    private Integer level;

    /**
     * Creates new form OrganicFrame
     * @param nodeName
     */
    public OrganicFrame(String nodeName) {
        initComponents();

        level = 0;
        for (ModelXBase org : FileX.organicList.GetAll()) {
            level++;
            if (getLevel(nodeName) == level) {
                this.organic = (Organic) org;
                break;
            }
        }

        LoadOrganic();

        lblLevel.setText("Level " + level.toString());
        txtDescription.Init(organic, "RENAME", organic.RENAME);

        rdDaysAfterPlanting.addChangeListener((javax.swing.event.ChangeEvent evt) -> {
            rdDaysAfterPlantingStateChanged(evt);
        });
        
        setImage(imagePanel, "Residue2.jpg");
        
        EventQueue.invokeLater(() -> {
            rdDaysAfterPlantingStateChanged(null);
            
            rdDaysAfterPlanting.setEnabled(!FileX.isFileOpenned || organic.GetSize() == 0);
            rdReportedDates.setEnabled(!FileX.isFileOpenned || organic.GetSize() == 0);
        });
    }

    /**
     *
     * @param name
     */
    @Override
    public void updatePanelName(String name) {
        FocusListener[] listens = txtDescription.getListeners(FocusListener.class);
        for (FocusListener li : listens) {
            txtDescription.removeFocusListener(li);
        }

        level = 0;
        for (ModelXBase f : FileX.organicList.GetAll()) {
            level++;
            if (getLevel(name) == level) {
                lblLevel.setText("Level " + level.toString());
                txtDescription.setText(getDescription(name));
                break;
            }
        }

        for (FocusListener li : listens) {
            this.addFocusListener(li);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupManagement = new javax.swing.ButtonGroup();
        lblLevel = new org.jdesktop.swingx.JXLabel();
        txtDescription = new xbuild.Components.XTextField();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        imagePanel = new javax.swing.JLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        rdDaysAfterPlanting = new javax.swing.JRadioButton();
        rdReportedDates = new javax.swing.JRadioButton();
        bnAddLayer = new javax.swing.JButton();
        bnDeleteLayer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
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

        imagePanel.setBackground(new java.awt.Color(153, 153, 153));

        jXLabel2.setText("Management");

        groupManagement.add(rdDaysAfterPlanting);
        rdDaysAfterPlanting.setSelected(true);
        rdDaysAfterPlanting.setText("Days After Planting");

        groupManagement.add(rdReportedDates);
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
                "Day", "<html><p align='center'>Residue<br>Material</p></html>", "<html><p align='center'>Amount<br>kg/ha</p></html>", "<html><p align='center'>Nitrogen<br>Concentration<br>%</p></html>", "<html><p align='center'>Phophorus<br>Concentration<br>%</p></html>", "<html><p align='center'>Potass.<br>Concentration<br>%</p></html>", "<html><p align='center'>Incorporation<br>%</p></html>", "<html><p align='center'>Incorporatin<br>Depth<br>cm</p></html>", "<html><p align='center'>Method of<br>Incorporatin<br>Code</p></html>"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(rdDaysAfterPlanting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdReportedDates)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdReportedDates)
                                .addComponent(rdDaysAfterPlanting))
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bnAddLayer)
                                    .addComponent(bnDeleteLayer))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        lblLevel1.setText("Organic Amendments");
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
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdDaysAfterPlantingStateChanged(javax.swing.event.ChangeEvent evt) {                                                 
        if (rdDaysAfterPlanting.isSelected()) {
            TableColumn col = jXTable1.getColumn(0);
            col.setHeaderValue("Days After Planting");
            if (organic.GetApps() != null) {
                organic.GetApps().forEach(h -> {
                    h.RDATE = null;
                });
            }
        } else {
            TableColumn col = jXTable1.getColumn(0);
            col.setHeaderValue("<html><p align='center'>Date<br>" + Variables.getDateFormatString() + "</p></html>");
            if (organic.GetApps() != null) {
                organic.GetApps().forEach(harvest -> {
                    harvest.RDAY = null;
                });
            }
        }
    }     
    
    private void bnAddLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddLayerActionPerformed
        OrganicApplication org;
        if (selectedRowIndex >= 0 && selectedRowIndex < organic.GetSize()) {
            OrganicApplication tmp = organic.GetApp(selectedRowIndex);
            org = tmp.Clone();
        } else {
            org = new OrganicApplication();
        }

        final OrganicDialog organicDialog = new OrganicDialog(null, true, rdDaysAfterPlanting.isSelected(), org);
        organicDialog.show();

        organicDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                OrganicApplication organicApp = organicDialog.GetData();
                if (organicApp != null && (organicApp.RDATE != null || organicApp.RDAY != null)) {
                    DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
                    while (model.getRowCount() > 0) {
                        model.removeRow(0);
                    }
                    
                    organic.AddApp(organicApp);
                    
                    for (int i = 0; i < organic.GetSize(); i++) {                        
                        model.addRow(SetRow(organic.GetApp(i)));
                    }
                }
                organicDialog.SetNull();
            }
        });
    }//GEN-LAST:event_bnAddLayerActionPerformed

    private void bnDeleteLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteLayerActionPerformed
        int nRow = jXTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
        model.removeRow(nRow);

        organic.RemoveAt(nRow);
        
        EventQueue.invokeLater(() -> {
            rdDaysAfterPlantingStateChanged(null);
            
            rdDaysAfterPlanting.setEnabled(!FileX.isFileOpenned || organic.GetSize() == 0);
            rdReportedDates.setEnabled(!FileX.isFileOpenned || organic.GetSize() == 0);
        });
    }//GEN-LAST:event_bnDeleteLayerActionPerformed

    private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked
        if (evt.getClickCount() == 2) {
            int nRow = jXTable1.getSelectedRow();
            final OrganicDialog organicDialog = new OrganicDialog(null, true, rdDaysAfterPlanting.isSelected(), organic.GetApp(jXTable1.getSelectedRow()));
            organicDialog.show();

            organicDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    OrganicApplication organicApp = organicDialog.GetData();
                    if (organicApp != null) {
                        DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
                        organic.SetAt(nRow, organicApp);
                        Object[] row = SetRow(organicApp);
                        for (int n = 0; n < row.length; n++) {
                            model.setValueAt(row[n], jXTable1.getSelectedRow(), n);
                        }
                    }
                    organicDialog.SetNull();
                }
            });
        } else {
            int nRow = jXTable1.getSelectedRow();

            if (nRow != selectedRowIndex) {
                selectedRowIndex = nRow;
            } else {
                selectedRowIndex = -1;
                jXTable1.clearSelection();
            }
        }
    }//GEN-LAST:event_jXTable1MouseClicked

    private void txtDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescriptionFocusLost
        if (txtDescription.getText() == null ? organic.RENAME != null : !txtDescription.getText().equals(organic.RENAME)) {
            l.myAction(new UpdateLevelEvent(this, "Organic Amendments", "Level " + level + ": " + txtDescription.getText(), level - 1));
        }
    }//GEN-LAST:event_txtDescriptionFocusLost

    private Object[] SetRow(OrganicApplication organicApp) {
        Object day;
        Object RCOD;
        Object RAMT;
        Object RESN;
        Object RESP;
        Object RESK;
        Object RINP;
        Object RDEP;
        Object RMET;
            
        try {
            day = Variables.getDateFormat().format(organicApp.RDATE);

            rdDaysAfterPlanting.setSelected(false);
            rdReportedDates.setSelected(true);
        } catch (Exception ex) {
            day = organicApp.RDAY;
            rdDaysAfterPlanting.setSelected(true);
            rdReportedDates.setSelected(false);
        }

        try {
            RCOD = ResiduesList.GetAt(organicApp.RCOD).Description;
        } catch (Exception ex) {
            RCOD = "";
        }
        try {
            RAMT = organicApp.RAMT;
        } catch (Exception ex) {
            RAMT = "";
        }
        try {
            RESN = organicApp.RESN;
        } catch (Exception ex) {
            RESN = "";
        }
        try {
            RESP = organicApp.RESP;
        } catch (Exception ex) {
            RESP = "";
        }
        try {
            RESK = organicApp.RESK;
        } catch (Exception ex) {
            RESK = "";
        }
        try {
            RINP = organicApp.RINP;
        } catch (Exception ex) {
            RINP = "";
        }
        try {
            RDEP = organicApp.RDEP;
        } catch (Exception ex) {
            RDEP = "";
        }
        try {
            RMET = FertilizerMethodList.GetAt(organicApp.RMET).Description;
        } catch (Exception ex) {
            RMET = "";
        }

        return new Object[]{day, RCOD, RAMT, RESN, RESP, RESK, RINP, RDEP, RMET};
    }

    private void LoadOrganic() {
        DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
        for (int i = 0; i < organic.GetSize(); i++) {
            if(organic.GetApp(i).RDATE != null){
                rdReportedDates.setSelected(true);
            }else{
                rdDaysAfterPlanting.setSelected(true);
            }
            model.addRow(SetRow(organic.GetApp(i)));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAddLayer;
    private javax.swing.JButton bnDeleteLayer;
    private javax.swing.ButtonGroup groupManagement;
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
