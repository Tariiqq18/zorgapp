public enum UserRoles {

        HUISARTS,
        APOTHEKER,
        FYSIOTHERAPEUT,
        TANDARTS;

        public boolean canViewMedication() {
            return this == HUISARTS || this == APOTHEKER;
        }
}
