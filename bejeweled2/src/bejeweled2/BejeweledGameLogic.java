package bejeweled2;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import gameLogic.GameLogic;
import userinput.UserInputController;

public class BejeweledGameLogic extends GameLogic {
//    static int counter = 0;
//    private static final int GAME_WIDTH = 1280, GAME_HEIGHT = 720, GEM_SIZE = 64;
//    private static final int ROW = 10, COLUMN = 14;
//    protected static Group root = new Group();
//    // private ImageView cursor, background;
//    protected static ImageView cursor, background;
//    BejeweledTileMap map = BejeweledTileMap.getInstance(ROW, COLUMN);
//    // private int cX = 0, cY = 0, tX = 0, tY = 0;
//    protected static int cX = 0, cY = 0, tX = 0, tY = 0;
//    protected static Label label;

//    protected static int score = 0;

    private BejeweledController controller = BejeweledController.getInstance();

    private static BejeweledGameLogic gameLogic;

    public static BejeweledGameLogic getInstance(){
        if (gameLogic == null){
            gameLogic = new BejeweledGameLogic();
        }
        return gameLogic;
    }

    @Override
    public void initializeTileMap() {
        Stage gameStage = new Stage();
        gameStage.setTitle("INF122 Team 6 - Bejeweled Fruits");

        controller.setup();
        controller.draw();

        Scene scene = new Scene(controller.getRoot(), controller.getGAME_WIDTH(), controller.getGAME_HEIGHT(), Color.TRANSPARENT);
        scene.getStylesheets().addAll(getClass().getResource("/style/style.css").toExternalForm());
        gameStage.setScene(scene);
        gameStage.show();
    }
    
    @Override
    public void generateTileEntity() {
        controller.draw();
    }
    
    @Override
    public void handleUserInput() {
        BejeweledInputAdapter inputAdapter = new BejeweledInputAdapter(controller);
        UserInputController.getInstance(inputAdapter).onInput();
    }

    @Override
    public void clearTiles() {
        for (int r = 0; r < controller.getROW(); r++){
            for (int c = 0; c < controller.getCOLUMN(); c++){
                int temp = controller.getScore();
                controller.eatable(r, c);
                controller.setScore(temp);
            }
        }
        controller.draw();
    }

    @Override
    public boolean checkEndGame() {
        System.out.println(controller.getCounter());
        if(controller.getCounter() == 2)
        {
            controller.setCounter(0);
            return true;
        }
        return false;
    }

    @Override
    public void save() {

    }

    @Override
    public void quit() {

    }

//    private void setup() {
//        // Set Background
//        background = new ImageView(new Image("images/bejeweled2/images/border.png"));
//        background.setFitWidth(GAME_WIDTH);
//        background.setFitHeight(GAME_HEIGHT);
//
//        // Set Cursor
//        cursor = new ImageView(new Image("images/bejeweled2/images/cursor.png"));
//        cursor.setFitWidth(GEM_SIZE);
//        cursor.setFitHeight(GEM_SIZE);
//
//        label = new Label();
//        label.setTranslateX(GAME_WIDTH - 330);
//        label.setTranslateY(200);
//        label.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
//
//        map.fillMap();
//    }
//    protected void draw()
//    {
//        root.getChildren().clear();
//        root.getChildren().add(background);
//        root.getChildren().add(label);
//        for(int r = 0; r < ROW; r++) {
//            for(int c = 0; c < COLUMN; c++) {
//                if(c == tX && r == tY)
//                {
//                    cursor.setTranslateX(c * GEM_SIZE + 20);
//                    cursor.setTranslateY(r * GEM_SIZE + 30);
//                    root.getChildren().add(cursor);
//                }
//                root.getChildren().add(map.getTile(r,c).getTileEntity().getImgV());
//            }
//        }
//        handleUserInput();
//    }
//    private void moveAnimation(int X, int Y)
//    {
//        TranslateTransition transition = new TranslateTransition();
//        transition.setDuration(Duration.seconds(1));
//        transition.setToX(X * GEM_SIZE + 20);
//        transition.setToY(Y * GEM_SIZE + 30);
//        //transition.setNode(cells[Y][X]);
//        transition.setNode(map.getTile(Y,X).getTileEntity().getImgV());
//        transition.play();
//    }
//    // private boolean eatable(int y, int x) {
//    protected boolean eatable(int y, int x) {
//        int count = 0, maxCount = 0;
//        int startX = x, startY = y;
//        int begin = -3, end = 3;
//        boolean verticle = false;
//
//        NextTileEntity nextTileEntity = new NextTileEntity(BejeweledGemFactory.getInstance());
//        String[] tileEntityNames = {"blue", "green", "orange", "purple", "red", "white", "yellow"};
//        Random random = new Random();
//
//        // Case - Verticle
//        while(y + begin < 0)begin++;
//        while(y + end > ROW - 1)end--;
//        for(int i = begin; i <= end; i++)
//        {
//            if(map.getTile(y,x).getTileEntity().getIconSrc().equals(map.getTile(y + i,x).getTileEntity().getIconSrc()))
//            {
//                count++;
//                if(count >= 2)
//                {
//                    startY = y + i - count + 1;
//                    if(startY < 0)
//                    {
//                        startY = 0;
//                        count--;
//                    }
//                    maxCount = count;
//                }
//            }else count = 0;
//        }
//        if(maxCount > 2)verticle = true;
//
//        // Case - Horizontal
//        begin = -3;
//        end = 3;
//        if(maxCount <= 2)
//        {
//            while(x + begin < 0)begin++;
//            while(x + end > COLUMN - 1)end--;
//            for(int i = begin; i <= end; i++)
//            {
//                if(map.getTile(y,x).getTileEntity().getIconSrc().equals(map.getTile(y,x + i).getTileEntity().getIconSrc()))
//                {
//                    count++;
//                    if(count >= 2)
//                    {
//                        startX = x + i - count + 1;
//                        if(startX < 0)
//                        {
//                            startX = 0;
//                            count--;
//                        }
//                        maxCount = count;
//                    }
//                }else count = 0;
//            }
//        }
//
//        if(maxCount > 2)
//        {
//            for(int i = 0; i < maxCount; i++){
//                int randomIndex = random.nextInt(tileEntityNames.length);
//                if(verticle == true) {
//                    nextTileEntity.addNewTileEntity(tileEntityNames[randomIndex], map.getTile(startY + i, startX));
//                    int temp = score;
//                    eatable(startY + i, startX);
//                    score = temp;
//                }
//                else {
//                    nextTileEntity.addNewTileEntity(tileEntityNames[randomIndex], map.getTile(startY, startX + i));
//                    int temp = score;
//                    eatable(startY, startX + i);
//                    score = temp;
//                }
//            }
//            score += maxCount * 10;
//            return true;
//        }
//
//        return false;
//    }
}