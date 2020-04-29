package com.Entities.Static;

import com.Entities.Entity;
import com.Main.Handler;

public abstract class StaticEntity extends Entity {
    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
}
