package de.gurkenlabs.litiengine.graphics.animation;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IGameLoop;
import de.gurkenlabs.litiengine.entities.DecorMob;
import de.gurkenlabs.litiengine.entities.IEntity;
import de.gurkenlabs.litiengine.graphics.Spritesheet;

public class DecorMobAnimationController extends AnimationController {
  private final DecorMob mob;

  public DecorMobAnimationController(final IEntity prop) {
    super(createAnimation((DecorMob) prop));
    this.mob = (DecorMob) prop;
  }

  public static Animation createAnimation(final DecorMob mob) {
    final Spritesheet spritesheet = findSpriteSheet(mob);
    if (spritesheet == null) {
      return null;
    }

    return new Animation(mob.getMobType(), spritesheet, true, true);
  }

  @Override
  public void update(IGameLoop loop) {
    super.update(loop);
    this.playAnimation(this.mob.getMobType());
  }

  private static Spritesheet findSpriteSheet(final DecorMob mob) {
    final String path = Game.getInfo().spritesDirectory() + "decormob-" + mob.getMobType().toLowerCase() +  ".png";
    final Spritesheet sheet = Spritesheet.find(path);
    return sheet;
  }

}