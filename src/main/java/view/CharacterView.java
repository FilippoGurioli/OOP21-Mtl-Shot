package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.Direction;
import util.Vector2D;
import util.map.MapConstants;

/**
 * TODO: javadoc.
 */
public class CharacterView {

    private final ImageView characterImageView;
    private final Image characterCrouchIcon;
    private final Image characterUp;
    private final Image characterDown;
    private final Image characterLeft;
    private final Image characterRight;

    /**
     * 
     */
    public CharacterView() {
        characterCrouchIcon = new Image(ClassLoader.getSystemResourceAsStream("croulpleier.png"));
        characterUp = new Image(ClassLoader.getSystemResourceAsStream("pleierUP.png"));
        characterDown = new Image(ClassLoader.getSystemResourceAsStream("pleierDOWN.png"));
        characterRight = new Image(ClassLoader.getSystemResourceAsStream("pleierRIGHT.png"));
        characterLeft = new Image(ClassLoader.getSystemResourceAsStream("pleierLEFT.png"));
        characterImageView = new ImageView(characterRight);
    }

    /**
     * 
     * @param position
     * @param crouch
     * @param direction
     */
    public void updateCharacter(final Vector2D position, final boolean crouch, final Direction direction) {
        characterImageView.setX(position.getX() * MapConstants.getTilesize());
        characterImageView.setY(position.getY() * MapConstants.getTilesize());
        switch (direction) {
        case UP:
            characterImageView.setImage(characterUp);
            break;
        case DOWN:
            characterImageView.setImage(characterDown);
            break;
        case RIGHT:
            characterImageView.setImage(characterRight);
            break;
        case LEFT:
            characterImageView.setImage(characterLeft);
            break;
        case NEUTRAL:
        default:
            break;
        }
        if (crouch) {
            characterImageView.setImage(characterCrouchIcon);
        }
    }

    /**
     * 
     * @return bla
     */
    public ImageView getCharacterImageView() {
        return characterImageView;
    }

}