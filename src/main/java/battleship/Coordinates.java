package battleship;

import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class Coordinates {
        private Integer X;
        private Integer Y;
        private Comparator compareCoordinates;

        public Coordinates() {
            this(0,0);
        }
        public Coordinates(Integer X, Integer Y) {
            this.X = X;
            this.Y = Y;
        }
        public Integer getX() {
            return X;
        }
        public Integer getY() {
            return Y;
        }
        public void setX(Integer X) {
            this.X = X;
        }
        public void setY(Integer Y) {
            this.Y = Y;
        }

        boolean isEqual(Coordinates b) {
            boolean isEqual = false;
            if (this.getX() == b.getX()) {
                if (this.getY() == b.getY()) {
                    isEqual = true;
                }
            }
            return isEqual;
        }

}

