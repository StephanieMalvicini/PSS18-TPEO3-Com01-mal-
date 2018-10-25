package Collisions;

public class PiercingBulletVisitor implements Visitor {

    float d;

    public PiercingBulletVisitor(float daño) {
        d = daño;
    }

    @Override
    public void visitEnemy(EnemyCollider e) {

    }

    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {

    }

    @Override
    public void visitEnemyBullet(EnemyBulletCollider b) {

    }

    @Override
    public void visitPlayer(PlayerCollider p) {

    }

    @Override
    public void visitEnemyBarricade(EnemyBarricadeCollider b) {

    }

    @Override
    public void visitBarricade(BarricadeCollider b) {

    }

    @Override
    public void visitPowerUp(PowerUpCollider b) {

    }

    @Override
    public void visitKamikazeShield(KamikazeShieldCollider b) {

    }

    @Override
    public void visitPiercingBulet(PiercingBulletCollider b) {

    }
}
