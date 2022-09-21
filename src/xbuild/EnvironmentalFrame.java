package xbuild;

import Extensions.Utils;
import Extensions.Variables;
import FileXModel.EnvironmentApplication;
import FileXModel.Environmental;
import FileXModel.FileX;
import FileXModel.IModelXBase;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import xbuild.Components.IXInternalFrame;
import xbuild.Events.UpdateLevelEvent;

/**
 *
 * @author Jazz
 */
public class EnvironmentalFrame extends IXInternalFrame {

    private Environmental environment;
    private int selectedRowIndex = -1;
    private Integer level;
    /**
     * Creates new form EnvironmentalFrame
     */
    public EnvironmentalFrame(String nodeName) {
        initComponents();
        
        level = 0;
        for(IModelXBase env : FileX.environmentals.GetAll()){
            level++;
            if(getLevel(nodeName) == level){
                this.environment = (Environmental)env;
                break;
            }
        }

        txtYear.setText(FileX.general.Year);

        LoadEnvApp();
        
        lblLevel.setText("Level " + level.toString());
        txtDescription.Init(environment, "ENVNAME", environment.ENVNAME);
        
        EventQueue.invokeLater(() -> {            
            setImage(imagePanel, setup.GetDSSATPath() + "\\Tools\\XBuild\\Env2.jpg");
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
        for (IModelXBase f : FileX.environmentals.GetAll()) {
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

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtYear = new javax.swing.JTextField();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable2 = new org.jdesktop.swingx.JXTable();
        bnAddLayer = new javax.swing.JButton();
        bnDeleteLayer = new javax.swing.JButton();
        lblLevel = new org.jdesktop.swingx.JXLabel();
        txtDescription = new xbuild.Components.XTextField();
        imagePanel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jXLabel1.setText("Year : ");

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Environmental Modification Applications", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jXTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><p align=center>Date</p></html>", "<html><p align=center>Day length<br>hours</p></html>", "<html><p align=center>Radiation<br>MJ/m2/d</p></html>", "<html><p align=center>Max Temp<br>C</p></html>", "<html><p align=center>Min Temp<br>C</p></html>", "<html><p align=center>Precipitation<br>mm</p></html>", "<html><p align='cente'r>CO2<br>vpm</p></html>", "<html><p align=center>Humidity<br>%</p></html>", "<html><p align=center>Wind<br>km/hour</p></html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable2.setShowGrid(true);
        jXTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jXTable2);

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

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bnAddLayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnDeleteLayer))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnDeleteLayer)
                    .addComponent(bnAddLayer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
        );

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
                        .addGap(53, 53, 53)
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable2MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2) {
            final EnvironmentalAppDialog appDialog = new EnvironmentalAppDialog(null, true, environment.GetApp(jXTable2.getSelectedRow()));
            appDialog.show();

            appDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    EnvironmentApplication envApp = appDialog.GetData();
                    if(envApp != null){
                        DefaultTableModel model = (DefaultTableModel) jXTable2.getModel();
                        Object[] vector = SetRow(envApp);
                        for (int n = 0; n < vector.length; n++)
                            model.setValueAt(vector[n], jXTable2.getSelectedRow(), n);
                    }
                    appDialog.SetNull();
                }
            });
        }
        else{
            int nRow = jXTable2.getSelectedRow();

            if(nRow != selectedRowIndex){
                selectedRowIndex = nRow;
            }
            else{
                selectedRowIndex = -1;
                jXTable2.clearSelection();
            }
        }

        //jXTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jXTable2.setRowSelectionAllowed(true);
    }//GEN-LAST:event_jXTable2MouseClicked

    private void bnAddLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddLayerActionPerformed
        EnvironmentApplication env = null;
        if (selectedRowIndex > 0 && selectedRowIndex < environment.GetSize()) {
            EnvironmentApplication tmp = environment.GetApp(selectedRowIndex);
            env = tmp.Clone();
        } else {
            env = new EnvironmentApplication();
        }

        final EnvironmentalAppDialog appDialog = new EnvironmentalAppDialog(null, true, env);
        appDialog.show();

        appDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                EnvironmentApplication envApp = appDialog.GetData();
                if(envApp != null){
                    DefaultTableModel model = (DefaultTableModel) jXTable2.getModel();
                    while(model.getRowCount() > 0)
                        model.removeRow(0);

                    environment.AddApp(envApp);
                    
                    for (int i = 0; i < environment.GetSize(); i++) {                        
                        model.addRow(SetRow(environment.GetApp(i)));
                    }
                }
                appDialog.SetNull();
            }
        });
    }//GEN-LAST:event_bnAddLayerActionPerformed

    private void bnDeleteLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteLayerActionPerformed
        int nRow = jXTable2.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jXTable2.getModel();
        model.removeRow(nRow);

        environment.RemoveAt(nRow);
    }//GEN-LAST:event_bnDeleteLayerActionPerformed

    private void txtDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescriptionFocusLost
        if(txtDescription.getText() == null ? environment.ENVNAME != null : !txtDescription.getText().equals(environment.ENVNAME)){
            l.myAction(new UpdateLevelEvent(this, "Environmental Modifications", "Level " + level + ": " + txtDescription.getText(), level - 1));
        }
    }//GEN-LAST:event_txtDescriptionFocusLost

    private Object[] SetRow(EnvironmentApplication envApp) {               
        ArrayList<Object> vector = new ArrayList<>();
        
        //DateFormat df = DateFormat.getDateInstance(DateFormat., l);
        try {
            vector.add(Variables.getDateFormat().format(envApp.ODATE));
        } catch (Exception e) {
            vector.add("");
        }

        try {
            vector.add(SetText(envApp.EDAY.toString(), envApp.EDAY_Fact.Code, jXTable2.getCellRect(1, 1, true)));
        } catch (Exception e) {
            vector.add("");
        }
        try {
            vector.add(SetText(Utils.FloatToString(envApp.ERAD), envApp.ERAD_Fact.Code, jXTable2.getCellRect(2, 1, true)));
        } catch (Exception e) {
            vector.add("");
        }
        try {
            vector.add(SetText(Utils.FloatToString(envApp.EMAX), envApp.EMAX_Fact.Code, jXTable2.getCellRect(3, 1, true)));
        } catch (Exception e) {
            vector.add("");
        }
        try {
            vector.add(SetText(Utils.FloatToString(envApp.EMIN), envApp.EMIN_Fact.Code, jXTable2.getCellRect(4, 1, true)));
        } catch (Exception e) {
            vector.add("");
        }
        try {
            vector.add(SetText(Utils.FloatToString(envApp.ERAIN), envApp.ERAIN_Fact.Code, jXTable2.getCellRect(5, 1, true)));
        } catch (Exception e) {
        }
        try {
            vector.add(SetText(Utils.FloatToString(envApp.ECO2), envApp.ECO2_Fact.Code, jXTable2.getCellRect(6, 1, true)));
        } catch (Exception e) {
            vector.add("");
        }
        try {
            vector.add(SetText(Utils.FloatToString(envApp.EDEW), envApp.EDEW_Fact.Code, jXTable2.getCellRect(7, 1, true)));
        } catch (Exception e) {
            vector.add("");
        }
        try {
            vector.add(SetText(Utils.FloatToString(envApp.EWIND), envApp.EWIND_Fact.Code, jXTable2.getCellRect(8, 1, true)));
        } catch (Exception e) {
            vector.add("");
        }

        return vector.toArray();
    }
    
    private String SetText(String Val, String Fact, Rectangle rec){
        return "<html><table width='" + rec.width + "'><tr><td width='50%'>" + Val + "</td><td width='50%' align='right'>" + Fact + "</td></tr></table></html>";
    }
    
    private void LoadEnvApp() {

        DefaultTableModel model = (DefaultTableModel) jXTable2.getModel();
        for(int n = 0;n < environment.GetSize();n++)
        {
            EnvironmentApplication envApp = environment.GetApp(n);
            /*Vector vector = new Vector();
            Locale l = new Locale("en", "US");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", l);

            //DateFormat df = DateFormat.getDateInstance(DateFormat., l);
            vector.addElement(df.format(envApp.ODATE));
            vector.add(SetText(envApp.EDAY.toString(), envApp.EDAY_Fact.Code, jXTable2.getCellRect(1, 1, true)));
            vector.add(SetText(Tools.FloatToString(envApp.ERAD), envApp.ERAD_Fact.Code, jXTable2.getCellRect(2, 1, true)));
            vector.add(SetText(Tools.FloatToString(envApp.EMAX), envApp.EMAX_Fact.Code, jXTable2.getCellRect(3, 1, true)));
            vector.add(SetText(Tools.FloatToString(envApp.EMIN), envApp.EMIN_Fact.Code, jXTable2.getCellRect(4, 1, true)));
            vector.add(SetText(Tools.FloatToString(envApp.ERAIN), envApp.ERAIN_Fact.Code, jXTable2.getCellRect(5, 1, true)));
            vector.add(SetText(Tools.FloatToString(envApp.ECO2), envApp.ECO2_Fact.Code, jXTable2.getCellRect(6, 1, true)));
            vector.add(SetText(Tools.FloatToString(envApp.EDEW), envApp.EDEW_Fact.Code, jXTable2.getCellRect(7, 1, true)));
            vector.add(SetText(Tools.FloatToString(envApp.EWIND), envApp.EWIND_Fact.Code, jXTable2.getCellRect(8, 1, true)));
             *
             */
            model.addRow(SetRow(envApp));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAddLayer;
    private javax.swing.JButton bnDeleteLayer;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTable jXTable2;
    private org.jdesktop.swingx.JXLabel lblLevel;
    private xbuild.Components.XTextField txtDescription;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
