package fr.free.nrw.commons.upload.depicts;

import java.util.List;

import fr.free.nrw.commons.BasePresenter;
import fr.free.nrw.commons.upload.structure.depictions.DepictedItem;

/**
 * The contract with which DepictsFragment and its presenter would talk to each other
 */
public interface DepictsContract {

    interface View {
        /**
         * Go to category screen
         */
        void goToNextScreen();

        /**
         * Go to media detail screen
         */
        void goToPreviousScreen();

        /**
         * show error in case of no depiction selected
         */
        void noDepictionSelected();

        /**
         * Show progress/Hide progress depending on the boolean value
         */
        void showProgress(boolean shouldShow);

        /**
         * decides whether to show error values or not depending on the boolean value
         */
        void showError(Boolean value);

        /**
         * add depictions to list
         */
        void setDepictsList(List<DepictedItem> depictedItemList);

        /**
         * Set thumbnail image for depicted item
         */
        void onImageUrlFetched(String response, int position);
    }

    interface UserActionListener extends BasePresenter<View> {

        /**
         * Takes to previous screen
         */
        void onPreviousButtonClicked();

        /**
         * Listener for the depicted items selected from the list
         */
        void onDepictItemClicked(DepictedItem depictedItem);

        /**
         * asks the repository to fetch depictions for the query
         *  @param query
         */
        void searchForDepictions(String query);

        /**
         * Check if depictions were selected
         * from the depiction list
         */
        void verifyDepictions();

        /**
         * Fetch thumbnail for the Wikidata Item
         * @param entityId entityId of the item
         * @param position position of the item
         */
        void fetchThumbnailForEntityId(String entityId, int position);
    }
}
