package is.demo.serenity.utils.excel;



    public class EsperaImplicita {

        public static void esperaImplicita (int segundos){
            try {
                Thread.sleep(segundos*1000);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }
        }
    }

