public enum UserRoles {

        HUISARTS,
        APOTHEKER,
        FYSIOTHERAPEUT,
        TANDARTS;

        public boolean canViewMedication() {
            return this == HUISARTS || this == APOTHEKER;
        }
        public boolean canUpdateMedication() {
                return this == APOTHEKER;
        }
        public boolean canViewPainkillersOnly() {
                return this == FYSIOTHERAPEUT;
        }
}
