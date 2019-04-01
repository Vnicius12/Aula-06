package br.com.bossini.pessoal_usjt_ads3anmca_app_helpdesk_viewholder;

import android.provider.BaseColumns;

import java.util.List;

public class HelpDeskContract {
    private HelpDeskContract(){

    }
    private static List <Fila> filas;

    static {
        filas.add(new Fila(1, "Desktop", R.drawable.ic_computer_black_24dp));
        filas.add((new Fila(2,"Telefonia", R.drawable.ic_phone_in_talk_black_24dp)));
        filas.add (new Fila (3, "Redes",R.drawable.ic_network_check_black_24dp));
        filas.add (new Fila (4, "Servidores",R.drawable.ic_poll_black_24dp));
        filas.add (new Fila (5, "Novos Projetos",R.drawable.ic_new_releases_black_24dp));
    }

    public static class FilaContract implements BaseColumns{
        public static final String TABLE_NAME = "tb_fila";
        public static final String COLUMN_NAME_ID = "id_fila";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_ICON_ID = "icon_id";
    }
    public static class ChamadoContract implements BaseColumns{
        public static final String TABLE_NAME = "tb_chamado";
        public static final String COLUMN_NAME_ID = "id_chamado";
        public static final String COLUMN_NAME_descricao = "descricao";
        public static final String COLUMN_NAME_STATUS = "status";
        public static final String COLUMN_NAME_DATA_ABERTURA = "dt_abertura";
        public static final String COLUMN_NAME_DATA_FECHAMENTO = "dt_fechamento";
    }

    public static String createTableFila(){
        String template = "CREATE TABLE %s (%s INTEGER PRIMARY_KEY, %s TEXT, %s INTEGER)";
        return String.format(template,
                FilaContract.TABLE_NAME,
                FilaContract.COLUMN_NAME_ID,
                FilaContract.COLUMN_NAME_NOME,
                FilaContract.COLUMN_NAME_ID);

    }
    public static String creatTableChamado(){
        String template = "CREATE TABLE %s (%s INTEGER PRIMARY_KEY, %s TEXT, %s TEXT, %s INTERGER, %s INTEGER, FOREING KEY(%s) REFERENCE %s (%s)";
        return String.format
                (template,
                        ChamadoContract.TABLE_NAME,
                        ChamadoContract.COLUMN_NAME_ID,
                        ChamadoContract.COLUMN_NAME_descricao,
                        ChamadoContract.COLUMN_NAME_DATA_ABERTURA,
                        ChamadoContract.COLUMN_NAME_DATA_FECHAMENTO,
                        ChamadoContract.COLUMN_NAME_STATUS,
                        FilaContract.COLUMN_NAME_ID,
                        FilaContract.COLUMN_NAME_ID,
                        FilaContract.TABLE_NAME,
                        FilaContract.COLUMN_NAME_ID
                );
    }
}
