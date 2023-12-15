package Creational.Builder;

public class Builder {
    private String car;
    private String carColor;
    private Builder(){}
    public static BuilderBuilder builder(){
        return new BuilderBuilder();
    }

    public static class BuilderBuilder{
        private String car;
        private String carColor;

        public BuilderBuilder setCar(String car) {
            this.car = car;
            return this;
        }

        public BuilderBuilder setCarColor(String carColor) {
            this.carColor = carColor;
            return this;
        }

        public Builder build(){
            Builder obj = new Builder();
            obj.car = this.car;
            obj.carColor = this.carColor;
            return obj;
        }
    }
}
