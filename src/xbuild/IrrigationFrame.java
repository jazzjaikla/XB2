package xbuild;

import DSSATModel.IrrigationMethodList;
import Extensions.Variables;
import FileXModel.FileX;
import FileXModel.IModelXBase;
import FileXModel.Irrigation;
import FileXModel.IrrigationApplication;
import java.awt.EventQueue;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import xbuild.Components.IXInternalFrame;
import xbuild.Events.UpdateLevelEvent;

/**
 *
 * @author Jazzy
 */
public class IrrigationFrame extends IXInternalFrame implements KeyListener {

    protected Irrigation irrig;
    private int selectedRowIndex = -1;
    private Integer level;
    /**
     * Creates new form IrrigationFrame
     */
    public IrrigationFrame(String nodeName) {
        initComponents();
        
        level = 0;
        for(IModelXBase ir : FileX.irrigations.GetAll()){
            level++;
            if(getLevel(nodeName) == level){
                this.irrig = (Irrigation)ir;
                break;
            }
        }
        
        txtEFIR.addKeyListener(this);

        LoadIrrigationApp();
        
        lblLevel.setText("Level " + level.toString());
        txtDescription.Init(irrig, "IRNAME", irrig.IRNAME);
        
        rdDaysAfterPlanting.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdDaysAfterPlantingStateChanged(evt);
            }
        });
        
        EventQueue.invokeLater(() -> {            
            setImage(imagePanel, setup.GetDSSATPath() + "\\Tools\\XBuild\\irrigation2.jpg");
            rdDaysAfterPlantingStateChanged(null);
        });
    }
    
    private void rdDaysAfterPlantingStateChanged(javax.swing.event.ChangeEvent evt) {                                                 
        if(rdDaysAfterPlanting.isSelected())
        {
            TableColumn col = jXTable1.getColumn(0);
            col.setHeaderValue("Days After Planting");
            if(irrig.GetApps() != null){
                irrig.GetApps().forEach(h -> {
                    h.IDATE = null;
                });
            }
            
            DefaultTableModel model = (DefaultTableModel)jXTable1.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                Object valueAt = model.getValueAt(i, 0);
                try {
                    int val = Integer.parseInt(valueAt.toString());
                    model.setValueAt(0, i, 0);
                } catch (NumberFormatException ex) {
                    model.setValueAt(0, i, 0);
                }
            }
        }
        else
        {
            TableColumn col = jXTable1.getColumn(0);
            col.setHeaderValue("<html><p align='center'>Date<br>" + Variables.getDateFormatString() + "</p></html>");
            if(irrig.GetApps() != null){
                irrig.GetApps().forEach(harvest -> {
                    harvest.IDAY = null;
                });
            }
            
            DefaultTableModel model = (DefaultTableModel)jXTable1.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                Object valueAt = model.getValueAt(i, 0);
                if(valueAt != null){
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
        for (IModelXBase f : FileX.irrigations.GetAll()) {
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
        imagePanel = new javax.swing.JLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        rdDaysAfterPlanting = new javax.swing.JRadioButton();
        rdReportedDates = new javax.swing.JRadioButton();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        txtEFIR = new javax.swing.JFormattedTextField();
        bnAddLayer = new javax.swing.JButton();
        bnDeleteLayer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        lblLevel = new org.jdesktop.swingx.JXLabel();
        txtDescription = new xbuild.Components.XTextField();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        imagePanel.setBackground(new java.awt.Color(153, 153, 153));

        jXLabel2.setText("Management");

        buttonGroup1.add(rdDaysAfterPlanting);
        rdDaysAfterPlanting.setSelected(true);
        rdDaysAfterPlanting.setText("Days After Planting");

        buttonGroup1.add(rdReportedDates);
        rdReportedDates.setText("On Reported Dates");

        jXLabel3.setText("Efficiency Fraction");

        txtEFIR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

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
                "Day", "<html><p align='center'>Amount of Water<br>mm</p></html>", "Operation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        lblLevel.setText("Level");
        lblLevel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescriptionFocusLost(evt);
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
                        .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdDaysAfterPlanting)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdReportedDates))
                                    .addComponent(txtEFIR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bnAddLayer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(bnDeleteLayer)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdDaysAfterPlanting)
                                    .addComponent(rdReportedDates))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEFIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bnDeleteLayer)
                                    .addComponent(bnAddLayer))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnAddLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddLayerActionPerformed
        IrrigationApplication ir = null;
        if (selectedRowIndex > 0 && selectedRowIndex < irrig.GetSize()) {
            IrrigationApplication tmp = irrig.GetApp(selectedRowIndex);
            ir = tmp.Clone();
        } else {
            ir = new IrrigationApplication();
        }

        final IrrigationDialog appDialog = new IrrigationDialog(null, true, rdDaysAfterPlanting.isSelected(), ir);
        appDialog.show();

        appDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                IrrigationApplication irrigApp = appDialog.GetData();
                if(irrigApp != null){
                    DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
                    while(model.getRowCount() > 0)
                        model.removeRow(0);
                    
                    irrig.AddApp(irrigApp);
                    
                    for (int i = 0; i < irrig.GetSize(); i++) {                        
                        model.addRow(SetRow(irrig.GetApp(i)));
                    }
                }
                appDialog.SetNull();
            }
        });
    }//GEN-LAST:event_bnAddLayerActionPerformed

    private void bnDeleteLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteLayerActionPerformed
        int nRow = jXTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
        model.removeRow(nRow);

        irrig.RemoveAt(nRow);
    }//GEN-LAST:event_bnDeleteLayerActionPerformed

    private void jXTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXTable1MouseClicked
        if(evt.getClickCount() == 2)
        {
            int nRow = jXTable1.getSelectedRow();
            IrrigationApplication ir = null;
            if(nRow >= 0){
                IrrigationApplication tmp = irrig.GetApp(nRow);
                ir = tmp.Clone();
            }
            else{
                ir = new IrrigationApplication();
            }

            final IrrigationDialog appDialog = new IrrigationDialog(null, true, rdDaysAfterPlanting.isSelected(), ir);
            appDialog.show();

            appDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    IrrigationApplication irrigApp = appDialog.GetData();
                    if(irrigApp != null){
                        DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
                        Vector vector = SetRow(irrigApp);
                        for(int n = 0;n < vector.size();n++)
                        model.setValueAt(vector.get(n), jXTable1.getSelectedRow(), n);
                    }
                    appDialog.SetNull();
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
        if(txtDescription.getText() == null ? irrig.IRNAME != null : !txtDescription.getText().equals(irrig.IRNAME)){
            l.myAction(new UpdateLevelEvent(this, "Irrigation", "Level " + level + ": " + txtDescription.getText(), level - 1));
        }
    }//GEN-LAST:event_txtDescriptionFocusLost

    public void keyTyped(KeyEvent e) {
        Update();
    }

    public void keyPressed(KeyEvent e) {
        Update();
    }

    public void keyReleased(KeyEvent e) {
        Update();
    }

    protected void Update() {
        try
        {
            irrig.EFIR = Float.parseFloat(txtEFIR.getText());
        }
        catch(Exception ex)
        {
            irrig.EFIR = null;
        }
    }

    private void LoadIrrigationApp() {
        try
        {
            txtEFIR.setText(irrig.EFIR.toString());
        }
        catch(Exception ex)
        {
            txtEFIR.setText("");
        }
        
        DefaultTableModel model = (DefaultTableModel) jXTable1.getModel();
        for(int i = 0;i < irrig.GetSize();i++)
        {
            model.addRow(SetRow(irrig.GetApp(i)));
        }
    }
    
    private Vector SetRow(IrrigationApplication irrigApp) {

        Vector vector = new Vector();
        
        try
        {
            vector.addElement(Variables.getDateFormat().format(irrigApp.IDATE));

            rdDaysAfterPlanting.setSelected(false);
            rdReportedDates.setSelected(true);
        }
        catch(Exception ex)
        {
            vector.add(irrigApp.IDAY);
            rdDaysAfterPlanting.setSelected(true);
            rdReportedDates.setSelected(false);
        }
        
        vector.add(irrigApp.IRVAL);
        vector.add(IrrigationMethodList.GetAt(irrigApp.IROP).Description);
        return vector;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAddLayer;
    private javax.swing.JButton bnDeleteLayer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXLabel lblLevel;
    private javax.swing.JRadioButton rdDaysAfterPlanting;
    private javax.swing.JRadioButton rdReportedDates;
    private xbuild.Components.XTextField txtDescription;
    private javax.swing.JFormattedTextField txtEFIR;
    // End of variables declaration//GEN-END:variables
}
